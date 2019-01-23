package com.roy

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.execution.QueryExecution
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.streaming.{OutputMode, StreamingQueryListener}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.util.QueryExecutionListener

case class Emp(name: String, dept: String)

object SparkApp extends App {

  val spark: SparkSession = SparkSession
    .builder
    .master("local[*]")
    .appName("SparkApp")
    .config("spark.driver.host", "localhost")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  spark.streams.addListener(new StreamingQueryListener{
    override def onQueryStarted(event: StreamingQueryListener.QueryStartedEvent): Unit = {
      println(s">>> Start: ${event.id}")
    }

    override def onQueryProgress(event: StreamingQueryListener.QueryProgressEvent): Unit = {
      println(s">>> Progress: ${event.progress}")
    }

    override def onQueryTerminated(event: StreamingQueryListener.QueryTerminatedEvent): Unit = {
      println(s">>> Terminated: ${event.id}, ${event.exception}")
    }
  })

  spark.listenerManager.register(new QueryExecutionListener {
    override def onSuccess(funcName: String, qe: QueryExecution, durationNs: Long): Unit = {
      println(s"### On Success: ${qe.optimizedPlan.stats}")
    }

    override def onFailure(funcName: String, qe: QueryExecution, exception: Exception): Unit = {
      println(s"### On Failure: ${exception.getMessage}")
    }
  })

  val schema = ScalaReflection.schemaFor[Emp].dataType.asInstanceOf[StructType]

  val query = spark
    .readStream
    .option("maxFilesPerTrigger", 1)
    .schema(schema)
    .json("src/main/resources/input")
    .groupBy(col("dept"))
    .count()
    .writeStream
    .outputMode(OutputMode.Complete())
    .format("console")
    .start()

  query.awaitTermination()
}
