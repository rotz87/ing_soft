#! /bin/sh

CLASSES="classes"
CLASSPATH="lib/mysql-connector-java-5.1.33-bin.jar:lib/orm.jar"
ARGS=

for arg in "$@" ; do
	ARGS="$ARGS \"$arg\""
done

if [ -z "$JAVACMD" ] ; then
	if [ -n "$JAVA_HOME"  ] ; then
		if [ -x "$JAVA_HOME/bin/java" ] ; then
			JAVACMD="$JAVA_HOME/bin/java"
		fi
	fi
fi

if [ -z "$JAVACMD" ] ; then
	JAVACMD=`which java 2> /dev/null `
	if [ -z "$JAVACMD" ] ; then
		JAVACMD=java
	fi
fi

if [ ! -x "$JAVACMD" ] ; then
	echo "Error: JAVA_HOME is not defined correctly."
	exit 1
fi

eval ""$JAVACMD" -classpath $CLASSES:$CLASSPATH $ARGS"
