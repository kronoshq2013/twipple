# twipple

TODO: write project discription

## usage build tools

### gradle

When do not install gradle then use "gradlew" by OS type.
* Windows: gradlew.bat <execute tasks>
* Unix: ./gradlew <execute tasks>

#### Compile on gradle

  gradle compileJava

#### Setup eclipse project

  gradle eclipse

#### Start Web Server

  gradle tomcatRunWar

#### DataBase

* 開発用DBはh2を使用
* WebServer起動と同時にDBサーバを起動するよう設定