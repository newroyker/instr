# instr
Instrumenting OSS Streaming Apps

# 3 ways to instrument
* `QueryExecutionListener` produces
```text
### On Success: Statistics(sizeInBytes=21.0 B, hints=none)
```
* `StreamingQueryListener` produces
```text
>>> Progress: {
  "id" : "4aa947ca-5063-4e2f-bec7-dd9544f3479a",
  "runId" : "fde1cf3e-972e-4113-8797-a66537f7591f",
  "name" : null,
  "timestamp" : "2019-01-22T23:58:50.628Z",
  "batchId" : 0,
  "numInputRows" : 1,
  "processedRowsPerSecond" : 0.1340662287169862,
  "durationMs" : {
    "addBatch" : 6886,
    "getBatch" : 90,
    "getOffset" : 107,
    "queryPlanning" : 184,
    "triggerExecution" : 7458,
    "walCommit" : 84
  },
  "stateOperators" : [ {
    "numRowsTotal" : 1,
    "numRowsUpdated" : 1,
    "memoryUsedBytes" : 41663,
    "customMetrics" : {
      "loadedMapCacheHitCount" : 0,
      "loadedMapCacheMissCount" : 0,
      "stateOnCurrentVersionSizeBytes" : 12863
    }
  } ],
  "sources" : [ {
    "description" : "FileStreamSource[file:/Users/debajyoti.roy/Dev/instr/src/main/resources/input]",
    "startOffset" : null,
    "endOffset" : {
      "logOffset" : 0
    },
    "numInputRows" : 1,
    "processedRowsPerSecond" : 0.1340662287169862
  } ],
  "sink" : {
    "description" : "org.apache.spark.sql.execution.streaming.ConsoleSinkProvider@4ad2aa7a"
  }
```
* Metrics sources (and one can add their custom `Source`)
```text
1/23/19 9:50:42 PM =============================================================

-- Gauges ----------------------------------------------------------------------
app-20190123214121-0000.driver.BlockManager.memory.diskSpaceUsed_MB
             value = 0
app-20190123214121-0000.driver.BlockManager.memory.maxMem_MB
             value = 21657
app-20190123214121-0000.driver.BlockManager.memory.maxOffHeapMem_MB
             value = 0
app-20190123214121-0000.driver.BlockManager.memory.maxOnHeapMem_MB
             value = 21657
app-20190123214121-0000.driver.BlockManager.memory.memUsed_MB
             value = 1
app-20190123214121-0000.driver.BlockManager.memory.offHeapMemUsed_MB
             value = 0
app-20190123214121-0000.driver.BlockManager.memory.onHeapMemUsed_MB
             value = 1
app-20190123214121-0000.driver.BlockManager.memory.remainingMem_MB
             value = 21655
app-20190123214121-0000.driver.BlockManager.memory.remainingOffHeapMem_MB
             value = 0
app-20190123214121-0000.driver.BlockManager.memory.remainingOnHeapMem_MB
             value = 21655
app-20190123214121-0000.driver.DAGScheduler.job.activeJobs
             value = 1
app-20190123214121-0000.driver.DAGScheduler.job.allJobs
             value = 7
app-20190123214121-0000.driver.DAGScheduler.stage.failedStages
             value = 0
app-20190123214121-0000.driver.DAGScheduler.stage.runningStages
             value = 1
app-20190123214121-0000.driver.DAGScheduler.stage.waitingStages
             value = 0
app-20190123214121-0000.driver.LiveListenerBus.queue.appStatus.size
             value = 0
app-20190123214121-0000.driver.LiveListenerBus.queue.executorManagement.size
             value = 0
app-20190123214121-0000.driver.LiveListenerBus.queue.shared.size
             value = 0
app-20190123214121-0000.driver.SparkSQLOperationManager.numHiveOperations
             value = 0
app-20190123214121-0000.driver.spark.streaming.955aa7f2-1aa3-4b60-825d-c2868cb35e9a.inputRate-total
             value = NaN
app-20190123214121-0000.driver.spark.streaming.955aa7f2-1aa3-4b60-825d-c2868cb35e9a.latency
             value = 38001
app-20190123214121-0000.driver.spark.streaming.955aa7f2-1aa3-4b60-825d-c2868cb35e9a.processingRate-total
             value = 0.02631509697113234

-- Counters --------------------------------------------------------------------
SparkStatusTracker.numInconsistentGetJobInfoResponses
             count = 0
app-20190123214121-0000.driver.Databricks.directoryCommit.autoVacuumCount
             count = 4
app-20190123214121-0000.driver.Databricks.directoryCommit.deletedFilesFiltered
             count = 0
app-20190123214121-0000.driver.Databricks.directoryCommit.filterListingCount
             count = 5
app-20190123214121-0000.driver.Databricks.directoryCommit.jobCommitCompleted
             count = 4
app-20190123214121-0000.driver.Databricks.directoryCommit.markerReadErrors
             count = 0
app-20190123214121-0000.driver.Databricks.directoryCommit.markerRefreshCount
             count = 0
app-20190123214121-0000.driver.Databricks.directoryCommit.markerRefreshErrors
             count = 0
app-20190123214121-0000.driver.Databricks.directoryCommit.markersRead
             count = 22
app-20190123214121-0000.driver.Databricks.directoryCommit.repeatedListCount
             count = 2
app-20190123214121-0000.driver.Databricks.directoryCommit.uncommittedFilesFiltered
             count = 0
app-20190123214121-0000.driver.Databricks.directoryCommit.untrackedFilesFound
             count = 3
app-20190123214121-0000.driver.Databricks.directoryCommit.vacuumCount
             count = 4
app-20190123214121-0000.driver.Databricks.directoryCommit.vacuumErrors
             count = 0
app-20190123214121-0000.driver.Databricks.preemption.numChecks
             count = 112
app-20190123214121-0000.driver.Databricks.preemption.numPoolsAutoExpired
             count = 4
app-20190123214121-0000.driver.Databricks.preemption.numTasksPreempted
             count = 0
app-20190123214121-0000.driver.Databricks.preemption.poolStarvationMillis
             count = 0
app-20190123214121-0000.driver.Databricks.preemption.schedulerOverheadNanos
             count = 37179109
app-20190123214121-0000.driver.Databricks.preemption.taskTimeWastedMillis
             count = 0
app-20190123214121-0000.driver.HiveExternalCatalog.fileCacheHits
             count = 2
app-20190123214121-0000.driver.HiveExternalCatalog.filesDiscovered
             count = 14
app-20190123214121-0000.driver.HiveExternalCatalog.hiveClientCalls
             count = 7
app-20190123214121-0000.driver.HiveExternalCatalog.parallelListingJobCount
             count = 0
app-20190123214121-0000.driver.HiveExternalCatalog.partitionsFetched
             count = 0
app-20190123214121-0000.driver.LiveListenerBus.numEventsPosted
             count = 668
app-20190123214121-0000.driver.LiveListenerBus.queue.appStatus.numDroppedEvents
             count = 0
app-20190123214121-0000.driver.LiveListenerBus.queue.executorManagement.numDroppedEvents
             count = 0
app-20190123214121-0000.driver.LiveListenerBus.queue.shared.numDroppedEvents
             count = 0

-- Histograms ------------------------------------------------------------------
app-20190123214121-0000.driver.CodeGenerator.compilationTime
             count = 20
               min = 10
               max = 221
              mean = 41.53
            stddev = 33.06
            median = 16.00
              75% <= 83.00
              95% <= 95.00
              98% <= 95.00
              99% <= 95.00
            99.9% <= 95.00
app-20190123214121-0000.driver.CodeGenerator.generatedClassSize
             count = 43
               min = 542
               max = 8768
              mean = 2537.11
            stddev = 2499.47
            median = 1170.00
              75% <= 4646.00
              95% <= 6871.00
              98% <= 8768.00
              99% <= 8768.00
            99.9% <= 8768.00
app-20190123214121-0000.driver.CodeGenerator.generatedMethodSize
             count = 161
               min = 1
               max = 652
              mean = 76.17
            stddev = 98.38
            median = 28.00
              75% <= 127.00
              95% <= 245.00
              98% <= 250.00
              99% <= 652.00
            99.9% <= 652.00
app-20190123214121-0000.driver.CodeGenerator.sourceCodeSize
             count = 20
               min = 929
               max = 16363
              mean = 5655.44
            stddev = 5417.19
            median = 1779.00
              75% <= 11847.00
              95% <= 16363.00
              98% <= 16363.00
              99% <= 16363.00
            99.9% <= 16363.00

-- Timers ----------------------------------------------------------------------
app-20190123214121-0000.driver.DAGScheduler.messageProcessingTime
             count = 501
         mean rate = 0.89 calls/second
     1-minute rate = 5.95 calls/second
     5-minute rate = 1.52 calls/second
    15-minute rate = 0.63 calls/second
               min = 0.01 milliseconds
               max = 334.92 milliseconds
              mean = 0.53 milliseconds
            stddev = 4.99 milliseconds
            median = 0.13 milliseconds
              75% <= 0.27 milliseconds
              95% <= 0.41 milliseconds
              98% <= 0.62 milliseconds
              99% <= 3.00 milliseconds
            99.9% <= 72.71 milliseconds
app-20190123214121-0000.driver.LiveListenerBus.listenerProcessingTime.com.databricks.backend.daemon.driver.DBCEventLoggingListener
             count = 668
         mean rate = 1.19 calls/second
     1-minute rate = 5.59 calls/second
     5-minute rate = 1.69 calls/second
    15-minute rate = 1.11 calls/second
               min = 0.00 milliseconds
               max = 219.36 milliseconds
              mean = 0.50 milliseconds
            stddev = 2.26 milliseconds
            median = 0.28 milliseconds
              75% <= 0.43 milliseconds
              95% <= 1.27 milliseconds
              98% <= 1.89 milliseconds
              99% <= 2.77 milliseconds
            99.9% <= 44.14 milliseconds
app-20190123214121-0000.driver.LiveListenerBus.listenerProcessingTime.org.apache.spark.status.AppStatusListener
             count = 668
         mean rate = 1.19 calls/second
     1-minute rate = 6.13 calls/second
     5-minute rate = 1.77 calls/second
    15-minute rate = 0.94 calls/second
               min = 0.00 milliseconds
               max = 81.09 milliseconds
              mean = 0.18 milliseconds
            stddev = 0.82 milliseconds
            median = 0.12 milliseconds
              75% <= 0.19 milliseconds
              95% <= 0.33 milliseconds
              98% <= 0.79 milliseconds
              99% <= 1.21 milliseconds
            99.9% <= 4.64 milliseconds
app-20190123214121-0000.driver.LiveListenerBus.listenerProcessingTime.org.apache.spark.util.ProfilerEnv$$anon$1
             count = 668
         mean rate = 1.19 calls/second
     1-minute rate = 6.43 calls/second
     5-minute rate = 1.84 calls/second
    15-minute rate = 0.97 calls/second
               min = 0.00 milliseconds
               max = 14.72 milliseconds
              mean = 0.00 milliseconds
            stddev = 0.03 milliseconds
            median = 0.00 milliseconds
              75% <= 0.00 milliseconds
              95% <= 0.00 milliseconds
              98% <= 0.01 milliseconds
              99% <= 0.02 milliseconds
            99.9% <= 0.65 milliseconds
app-20190123214121-0000.driver.LiveListenerBus.queue.appStatus.listenerProcessingTime
             count = 668
         mean rate = 1.19 calls/second
     1-minute rate = 6.13 calls/second
     5-minute rate = 1.77 calls/second
    15-minute rate = 0.94 calls/second
               min = 0.03 milliseconds
               max = 235.66 milliseconds
              mean = 0.70 milliseconds
            stddev = 5.09 milliseconds
            median = 0.26 milliseconds
              75% <= 0.37 milliseconds
              95% <= 1.52 milliseconds
              98% <= 3.20 milliseconds
              99% <= 6.66 milliseconds
            99.9% <= 104.74 milliseconds
app-20190123214121-0000.driver.LiveListenerBus.queue.executorManagement.listenerProcessingTime
             count = 668
         mean rate = 1.19 calls/second
     1-minute rate = 6.43 calls/second
     5-minute rate = 1.84 calls/second
    15-minute rate = 0.97 calls/second
               min = 0.00 milliseconds
               max = 14.85 milliseconds
              mean = 0.01 milliseconds
            stddev = 0.03 milliseconds
            median = 0.01 milliseconds
              75% <= 0.01 milliseconds
              95% <= 0.02 milliseconds
              98% <= 0.03 milliseconds
              99% <= 0.04 milliseconds
            99.9% <= 0.67 milliseconds
app-20190123214121-0000.driver.LiveListenerBus.queue.shared.listenerProcessingTime
             count = 668
         mean rate = 1.19 calls/second
     1-minute rate = 5.59 calls/second
     5-minute rate = 1.69 calls/second
    15-minute rate = 1.11 calls/second
               min = 0.03 milliseconds
               max = 219.53 milliseconds
              mean = 0.58 milliseconds
            stddev = 2.33 milliseconds
            median = 0.33 milliseconds
              75% <= 0.49 milliseconds
              95% <= 1.53 milliseconds
              98% <= 2.35 milliseconds
              99% <= 3.40 milliseconds
            99.9% <= 44.21 milliseconds
```
