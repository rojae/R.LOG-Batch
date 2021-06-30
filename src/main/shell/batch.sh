
# execute to batch.jar

 function task {
     echo =================================== DEMON START ===================================
     echo ============================== $(date "+%Y-%m-%d %T") ===================================
}

    task >> /Users/rojae/Documents/R.LOG-Batch/logs/batch-$(date "+%Y%m%d").log
    java -jar /Users/rojae/Documents/R.LOG-Batch/target/batch-0.0.1.jar date=$(date "+%s") >> /Users/rojae/Documents/R.LOG-Batch/logs/batch-$(date "+%Y%m%d").log
