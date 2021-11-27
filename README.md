# SpringBoot-UserAccountAPI

## 基礎需求

查詢會員(分頁)

* API路徑定義 xxx@host/api/users/page 

新增會員
* API路徑定義 xxx@host/api/users/add 

修改會員
* API路徑定義 xxx@host/api/users/update 

## 進階需求
以 redis 做快取效能優化 ( redission libary )

### 會員資料格式

* 帳號 account String
* 姓名 name String
* 電話 phone ( 台灣電話檢查 phone regular expressionr檢查 ) String
* 狀態 status ( 0啟用 1停用 2刪除 ) Integer

### 程式架構限制
採MVC設計 code package 採三個分類撰寫相應功能
* controller - 接收並驗證後回傳service結果
* persistence  - 使用 jdbctemplate存取db
* service - 使用persistence提供的資料做處理

### 限定開發工具
資料庫: posgresql, dbeaver\
IDE: eclipse\
框架: spring boot 2.0\
java: java 11 & jdbc template

### 參考資料
* [30天學習Spring MVC 系列](https://ithelp.ithome.com.tw/users/20107812/ironman/1538?page=1)
* [Spring框架自學之路——JdbcTemplate](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/527325/)
