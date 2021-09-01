# ユーザコードでクラスクエリを記述する方法のサンプル

## サンプルコードについて
この Git のサンプルコードは、[InterSystems 開発者コミュニティ](https://jp.community.intersystems.com/)に公開している以下記事のサンプルコードです。  
  
[SQL文ではなく、ユーザコードでクラスクエリを記述する方法はありますか？](https://jp.community.intersystems.com/node/502451)
  
## 含まれるファイル

* TestSP.xml　　　　　<font color="ForestGreen">// このサンプル実行に必要なクラス定義</font>
* userquerytest.xml　 <font color="ForestGreen">// このサンプル実行に必要なクラス定義</font>
* IRISPersentG.java　<font color="ForestGreen">// Javaサンプル（JDBCストアドプロシジャ）</font>  
  
## セットアップ方法
動作バージョンIRIS　V2018.1以降
 
 
TestSP.xml, userquerytest.xml をインポートします。
  - スタジオにてUSERネームスペースにインポートし、コンパイルしてください。
  - TestSP.xmlをインポートすると、User.TestStoredProc1 クラスがインポートされます。
  - このクラスには、ユーザコードで記述されたクエリ G が定義されています。
  - G クエリでは、引数に指定されたグローバル変数名の、第1番目のサブスクリプトとそのデータを検索し、結果セットオブジェクトとして結果を返します。
  
## 実行方法
#### 1. グローバル変数を作成します。
 
 
#### 2. 任意のグローバル変数名で、適当にデータを作成してください。
  
例）
```
for i=1:1:10 set ^test(i)="あいうえお"_i
```

#### 3. COSサンプルを実行します。
```
Do ^UserQuerytest()
```

実行例）
```
USER>do ^UserQuerytest()
グローバル名を入力 ^test
^test(1) = あいうえお1
^test(2) = あいうえお2
^test(3) = あいうえお3
^test(4) = あいうえお4
^test(5) = あいうえお5
^test(6) = あいうえお6
^test(7) = あいうえお7
^test(8) = あいうえお8
^test(9) = あいうえお9
^test(10) = あいうえお10
```
  
#### 4. CLASSPATH にjarファイルを追加します。
  
jarファイルは、以下のディレクトリにあります。
  
　＜IRIS インストールディレクトリ＞Dev\java\lib\JDKnn\　  <-- ここ
  
V2021.1 の場合は以下になります。  
	＜IRISインストールディレクトリ＞\dev\java\lib\JDKnn\intersystems-jdbc-3.n.0.jar
  
#### 5. Javaサンプルをコンパイル・実行します。  
```  
C:\temp\java>javac IRISPersentG.java

C:\temp\java>java IRISPersentG
Enter Global Name: ^test
Node   Value
^test(1)  あいうえお1
Node   Value
^test(2)  あいうえお2
Node   Value
^test(3)  あいうえお3
Node   Value
^test(4)  あいうえお4
Node   Value
^test(5)  あいうえお5
Node   Value
^test(6)  あいうえお6
Node   Value
^test(7)  あいうえお7
Node   Value
^test(8)  あいうえお8
Node   Value
^test(9)  あいうえお9
Node   Value
^test(10)  あいうえお10

```
