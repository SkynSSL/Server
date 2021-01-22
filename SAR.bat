   ::Copyright © MMVIII all rights reserved 2008
       @echo off
                  title Server Automated Restarter
           :start
                  set time=100072800
                  start run.bat
           :loop
                  cls
                  IF %time% GTR 0 (
                   set /a time=%time% - 1
                    set /a min=%time%/60
                     echo Next Restart In %time% Seconds.
                    echo   %time% Seconds is %min% Minutes.
                   ping 127.0.0.1 -n 2 > NUL
                  goto loop
                  ) 
           taskkill /f /im java.exe
          cls
         goto start
     ::Made By RSC/Logical