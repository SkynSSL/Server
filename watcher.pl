#!/usr/bin/perl
use warnings;
use strict;


print "Watcher Started\n";
while(1){
    my $git_updated = `git fetch && git status | head -n 2`;
        print $git_updated;
    if ($git_updated =~ /Your branch is behind 'origin\/' by/) {
        print `git pull`;
        system("./compiler.sh");
        system("./run.sh &");
    }
    sleep 60;
}
