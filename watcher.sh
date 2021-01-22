ENVIR=`awk {'if ($1 == "type") print $3'} Data/cfg/server_properties.cfg`;
ps aux | grep "watcher.pl --ENV=$ENVIR" | awk {'print $2'} | xargs kill -9;
nohup ./watcher.pl --ENV=$ENVIR &
sleep 1;
tail -f nohup.out
