package kr.rlog.batch.sh;

import java.io.IOException;
import java.util.Map;

public class DatabaseShell {

    ShellRunner shRunner = new ShellRunner();

    /*
     * 데이터베이스 백업은, 따로 동작하는게 좋지 않을까?
     * 1. 배치 오류로 인한 백업
     * 2. 오히려 sh로 작성하는 것이 간단
     * ~ 자바배치에 예외적으로 등록하지 않음
     * ~ 데이터베이스 백업은 sh을 직접 crontab에 등록하자
     */
    public void doBackup() throws IOException, InterruptedException {
        String command = "sh /home/ubuntu/R.LOG-Batch/src/main/shell/mysql-backup.sh";
        String[] callCmd = {"/bin/bash", "-c", command};
        Map map = shRunner.execCommand(callCmd);
        System.out.println(map);
    }
}