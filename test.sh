#!/bin/bash
#================================================================
# HEADER
#================================================================
#% SYNOPSIS
#+    ${SCRIPT_NAME} [-h] [-v] [-t[tags]] [-u[url]] [-l[lang]] [-b[browser]]
#%
#% OPTIONS
#%
#%    -h, --help                          Print this help
#%    -s, --setup                         Run tests setup
#%    -t [tags], --tags [tags]            Run tests with specified tags (@Smoke)
#%    -u [url], --url [url]               Set url
#%                                        The default value is hrc.deodev.pl
#%    -l [lang], --lang [lang]            Set language (pl-pl, en-gb)
#%    -b [browser], --browser [browser]   Set browser
#%                                        The default value is chrome
#%
#% EXAMPLES
#%    ${SCRIPT_NAME} -b firefox -t "@Smoke" -u hrc.deodev.pl -l en-gb
#%
#================================================================
# END_OF_HEADER
#================================================================

SCRIPT_HEADSIZE=$(head -200 ${0} |grep -n "^# END_OF_HEADER" | cut -f1 -d:)
SCRIPT_NAME="$(basename ${0})"

runSetupCommand="docker run --rm --name maven --network host -i -v "$PWD"/src:/usr/src/app/src deosite/maven verify -Dcucumber.filter.tags="\""@Setup"\"""
runCommand="docker run --rm --name maven --network host -i -v "$PWD"/src:/usr/src/app/src -v "$PWD"/reports:/usr/src/app/target/site/serenity deosite/maven verify -P parallel"

browser=chrome
video=false

usage() { printf "Usage: "; head -${SCRIPT_HEADSIZE:-99} ${0} | grep -e "^#+" | sed -e "s/^#+[ ]*//g" -e "s/\${SCRIPT_NAME}/${SCRIPT_NAME}/g" ; }
usage_full() { head -${SCRIPT_HEADSIZE:-99} ${0} | grep -e "^#[%+-]" | sed -e "s/^#[%+-]//g" -e "s/\${SCRIPT_NAME}/${SCRIPT_NAME}/g" ; }

setup() {
  docker pull selenium/standalone-firefox:latest
  docker pull selenium/standalone-chrome:latest
  docker build -t deosite/maven .
}

open_reports_link() {
  if which xdg-open > /dev/null
    then
      xdg-open "$PWD"/reports/index.html
  elif which gnome-open > /dev/null
    then
      gnome-open "$PWD"/reports/index.html
  fi
}

set_tags() {
  runCommand="${runCommand} -Dcucumber.filter.tags=$1"
}

set_url() {
  runCommand="${runCommand} -Dhome.page=$1"
  runSetupCommand="${runSetupCommand} -Dhome.page=$1"
}

set_lang() {
  runCommand="${runCommand} -Dweb.locale=$1"
  runSetupCommand="${runSetupCommand} -Dweb.locale=$1"
}

set_browser() {
  browser=$1
}

add_browser_properties() {
  runCommand="${runCommand} -Dproperties=${browser}.properties"
}

start_browser() {
  docker run -d --network host --name selenium -e SE_NODE_MAX_SESSIONS=11 --shm-size 2g selenium/standalone-"$browser":latest
}

stop_browser() {
  docker stop selenium && docker rm selenium
}

run_tests() {
  add_browser_properties
  start_browser
  eval "${runCommand}"
  stop_browser
  open_reports_link
}


while [ $# -gt 0 ]; do
  case "$1" in
    --help|-h) usage_full ; exit ;;
    --setup|-s) setup ; exit ;;
    --tags|-t) set_tags "$2" ; shift ;;
    --url|-u) set_url "$2" ; shift ;;
    --lang|-l) set_lang "$2" ; shift ;;
    --device|-d) ;;
    --browser|-b) set_browser "$2" ; shift ;;
    *) break
  esac
shift
done

#eval "${runSetupCommand}"
run_tests