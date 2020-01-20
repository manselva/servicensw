# servicensw

UI Automation base project for testing a scenario on Service NSW

to execute project can be set on an jenkins build, and triggered with the following command,

mvn clean install -Denv=https://www.service.nsw.gov.au -Dbrowser=chrome

-Dbrowser can be set to different browser to execute on the same.
As of now the driver is only set for the Chrome. Code is designed to accept multiple browsers.
