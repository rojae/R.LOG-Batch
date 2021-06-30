# R.LOG Batch Program
- shell 사용
- crontab 사용

## batch task list
- 메일 미인증 회원, 매일 자정마다 삭제
- 추가 개발진행..

#
## batch shell 추가 (예제)

### batch.sh (1분에 3번 작동)

```shell
# execute to batch.jar

 function task {
     echo =================================== DEMON START ===================================
     echo ============================== $(date "+%Y-%m-%d %T") ===================================
}

    task >> /Users/rojae/[경로]/logs/batch-$(date "+%Y%m%d").log
    java -jar /Users/rojae/[경로]/batch-0.0.1.jar date=$(date "+%s") >> /Users/rojae/[경로]/logs/batch-$(date "+%Y%m%d").log

```




## crontab에 추가 (예제)
```shell
#!/bin/bash
0 0 * * * sh /Users/[경로]/R.LOG-Batch/src/main/shell/batch.sh
```
