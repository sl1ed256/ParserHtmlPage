## ParserHtmlPage

An application that allows you to download an HTML page on your computer's hard drive and provides statistics on
the number of words in the console. The program works with utf-8 encoding.

## Technologies used

- Java.
- Other:
    - Connect to page and parse HTML text [Jsoup](https://jsoup.org/).
    - Tests [junit5](https://github.com/junit-team/junit5).

## Parameters
1. As input to the application, it takes a string with the address
   web pages (example: https://yandex.ru/). Also, the application accepts the path where to save the file (example: src).
2. As a result of the work, the program saves an html page called "result.html". It also prints the number of words in the console. 
