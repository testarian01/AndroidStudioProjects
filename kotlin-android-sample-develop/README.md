# Kotlinスタートブック サンプルアプリ

## ビルド

本書の想定環境で、このファイルのあるディレクトリをカレントディレクトリとし、下記のコマンドを実行してください。

    ./gradlew assembleDebug

すると、app/build/outputs/apk/app-debug.apkというファイルが得られるので、これをAndroid端末にインストールすることができます。

## 注意

本書に掲載しているコードと一部異なります。

* Dagger2を使ったモックの差し込みによるコード
* 依存ライブラリのバージョン
* プロパティの可視性修飾子
* `ArticleListAdapter`が`ArrayAdapter`を継承