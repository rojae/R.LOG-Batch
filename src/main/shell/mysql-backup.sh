#!/bin/bash
#------------------------------------------- #
# 이 구역 아래에 쓰는것 처럼 shell script의 라벨을 # 작성 해주면 좋습니다.
# Backup Shell Script #
# Developer : 이름 (DBA) #
# date of initial development 2020-07-02
# Final modification date 2020-07-02
#-------------------------------------------
#===========================================
# 2020-07-04 # Task List
#-------------------------------------------
#
# Create Database Backup .sql, .log
# Delete 1Week Ago Backup .sql, .log
#
#===========================================


# Variable Declaration
BAK_FILE_NM=_db_backup_`date +"%Y%m%d"`.sql
BAK_LOG_FILE_NM=0db_backup_`date +"%Y%m%d"`.log
BAK_FILE_SAVE_PATH=/home/ubuntu/mysql_backup/database_backup_files
BAK_FILE_DIRECTORY=`date +"%Y%m%d"`
WEEK_AGO=`date -d '1 week ago' +"%Y%m%d"`
MYSQL_HOST=''
MYSQL_DB_NAME=''
MYSQL_USER=''
MYSQL_PASSWORD=''

# 암호를 노출하기 싫다면 암호화된 텍스트로 저장하여 불러오는 방법도 있습니다.
# 또는 DB 접속 자체를 암호를 입력하지 않도록 설정을 하는 방법도 있습니다.

# create backup directory
mkdir ${BAK_FILE_SAVE_PATH}/${BAK_FILE_DIRECTORY}

# backup start
        echo `date +"%Y-%m-%d %H:%M:%S"`" <<<"$backup_database" backup shell script start!>>>" >> ${BAK_FILE_SAVE_PATH}/${BAK_FILE_DIRECTORY}/${BAK_LOG_FILE_NM}
        mysqldump -h${MYSQL_HOST} -u${MYSQL_USER} -p${MYSQL_PASSWORD} --databases ${MYSQL_DB_NAME} > ${BAK_FILE_SAVE_PATH}/${BAK_FILE_DIRECTORY}/$backup_database${BAK_FILE_NM} 2>&1 &&
        echo `date +"%Y-%m-%d %H:%M:%S"`" <<<"$backup_database" backup shell script end!>>>" >> ${BAK_FILE_SAVE_PATH}/${BAK_FILE_DIRECTORY}/${BAK_LOG_FILE_NM}
        echo "" >> ${BAK_FILE_SAVE_PATH}/${BAK_FILE_DIRECTORY}/${BAK_LOG_FILE_NM}

# Delete 1Week Ago Script
rm -rf ${BAK_FILE_SAVE_PATH}/${WEEK_AGO}