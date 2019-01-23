# instr
Instrumenting OSS Streaming Apps

# Listeners
* `StreamingQueryListener` produces
```text
### On Success: Statistics(sizeInBytes=21.0 B, hints=none)
```
* `QueryExecutionListener` produces
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
