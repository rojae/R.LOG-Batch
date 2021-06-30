# Shutdown All Java Task

#!/bin/sh
echo "Java Kill";
kill -9 `ps -ef|grep java|awk '{print $2}'`
