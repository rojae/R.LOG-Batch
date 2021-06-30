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
 #!/usr/bin/vi
 
 SLEEP_SECOND=20

 function task {
     echo =================================== DEMON START ===================================
     echo ============================== $(date "+%Y-%m-%d %T") ===================================
}

for i in $(seq -s " " 1 ${SLEEP_SECOND} 60);do
    task > /Users/[경로]/batch.log
    java -jar /Users/[경로]/batch.jar?date=$(date "+%Y-%m-%d %T") > /Users/[경로]/batch.log
    sleep ${SLEEP_SECOND};
 done
```




## crontab에 추가 (예제)
```shell
#!/bin/bash
00 3 * * * sh /Users/[경로]/batch.sh
```
