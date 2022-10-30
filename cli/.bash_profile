# File   : .bash_profile
# Purpose: Linux home environment properties
# Authoer: Rubens Gomes

# source the users bashrc if it exists
if [ -f "${HOME}/.bashrc" ] ; then
  source "${HOME}/.bashrc"
fi

C_DRIVE="/cygdrive/c"

# Windows System Environment Variables:
# ${GRADLE}, ${JDK8}, ${JDK11}
GRADLE_HOME="${GRADLE}"
export GRADLE_HOME

JAVA_HOME=
#JAVA_HOME="${JDK8}"
JAVA_HOME="${JDK11}"
export JAVA_HOME

CLASSPATH=
export CLASSPATH

# fix color display in mvn
TERM="cygwin"
export TERM

# Miscellaneous
TOOLS_HOME="${C_DRIVE}/tools"
PROG_DIR="${C_DRIVE}/Program Files"
WIN_SYSTEM32="${C_DRIVE}/Windows/System32"

# My local Windows tools (C:\tools) have the following tools:
# C:\tools\curl-7.84.0_9-win64-mingw
# C:\tools\gradle\gradle-7.5.1
# C:\tools\jdk8u342-b07
# C:\tools\jdk-11.0.16+8
# C:\tools\maven\apache-maven-3.8.6
# 
# Applications
GIT_HOME="${PROG_DIR}/Git"
M2_HOME="${TOOLS_HOME}/maven/apache-maven-3.8.6"
CONFLUENT_HOME="${TOOLS_HOME}/confluent"

# Confluent log folder
CONFLUENT_CURRENT="/tmp/confluent"
export CONFLUENT_CURRENT

# customize the PATH
PATH="${CONFLUENT_HOME}:${PATH}"
PATH="${CURL_HOME}/bin:${PATH}"
PATH="${GIT_HOME}/cmd:${PATH}"
PATH="${GRADLE_HOME}/bin:${PATH}"
PATH="${JAVA_HOME}/bin:${PATH}"
PATH="${M2_HOME}/bin:${PATH}"
PATH="${HOME}/bin:${PATH}"
# notice Windows programs are last in the PATH
PATH="${PATH}:${WIN_SYSTEM32}"

# Set MANPATH so it includes users' private man if it exists
if [ -d "${HOME}/man" ]; then
  MANPATH="${HOME}/man:${MANPATH}"
fi

# Set INFOPATH so it includes users' private info if it exists
if [ -d "${HOME}/info" ]; then
  INFOPATH="${HOME}/info:${INFOPATH}"
fi
