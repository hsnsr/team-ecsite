use bloomdb;

INSERT INTO mst_user (user_name,password,family_name,first_name,family_name_kana,first_name_kana,gender)
VALUES('test@example.com','test','テスト','太郎','てすと','たろう',0);

INSERT INTO mst_category (category_name,category_description)
VALUES('アクション/バトル','大迫力！'),
('スポーツ','青春！涙腺！'),
('キッズ','お子様と一緒に楽しめる！');

INSERT INTO mst_product (product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)
VALUES('ONE PIECE','わんぴーす','海洋冒険ロマン！',1,300,'/img/onepiece.jpg','2022/4/25','ゴーイングメリー'),
('僕のヒーローアカデミア','ぼくのひーろーあかでみあ','個性！',1,300,'/img/heroaka.jpg','2022/4/25','プルスウルトラ'),
('ハイキュー！！','はいきゅー','排球劇的青春！',2,200,'/img/hq.jpg','2022/4/20','烏野高校'),
('アオアシ','あおあし','Jユースの世界！',2,200,'/img/aoashi.jpg','2022/4/20','エスペリオンユース'),
('名探偵コナン','めいたんていこなん','謎解キッズ！',3,100,'/img/konan.jpg','2022/4/15','毛利小五郎探偵事務所'),
('ドラえもん','どらえもん','ネコ型ロボット！',3,100,'/img/doraemon.jpg','2022/4/15','トーキョーマツシバ');