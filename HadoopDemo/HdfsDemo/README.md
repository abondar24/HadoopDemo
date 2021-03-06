# HDFS Demo.

Several examples of Hadoop Distributes File System usage.

## Demos

1. Copy File (cfc) - Copy a file from local file system to HDFS.
2. File System Cat (fscc) - Show contents of file on stored in HDFS.
3. File System Double Cat (fsdc) - Show contents of file on stored in HDFS twice using seek.
4. List status (lsc) - Show file statuses for path.
5. Url Cat (ucc) - Show file contents from HDFS using URLStreamHandler

## Build and Run
```
mvn clean install

cd <hadoop-dir>/bin

./hadoop jar <path-to-jar>/hdfs.jar <demo-name>  <path-to-input-file> 
```

## Notes

- Argument with demo name is in ().
- Demo data is in Input data directory.
- Copy File requires and additional argument - directory name on hadoop fs. Format hdfs://localhost/<user>/<path>/<file-name>
- Input files for demo 2-5 must be on hdfs. Copy them using Copy File demo.
- List status requires path to HDFS directory instead of file.
