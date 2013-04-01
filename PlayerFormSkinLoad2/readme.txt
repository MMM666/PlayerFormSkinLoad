プレーヤのモデルをSkinLoad互換に置換えるMOD PlayerFormSkinLoad2 1.2.5 Rev1


プレーヤーモデルをおこたさん作成「PlayerFormSkinLoadPlus」の互換モデルに置き換えるMODです。
BurningPlayerを取り込みました。
別のMODを出すまでのつなぎです。



利用条件
	・おこたんさんに感謝の祈りを捧げてください。
	・動画等での使用、改造、転載すきにしてもよいのよ？
	・ただし、商用利用は除く。
	・あと、いかなる意味でも作者は責任をとりませぬ。



使い方
	要Modloader。
	%appdata%/.mincraft/mods/にZIPのまま放りこめば動くはずです。
	%appdata%/.mincraft/config/mod_PlayerFormSkinLoad2.cfgが設定ファイルです、適当にどうぞ。
	PlayerAPIに対応しています。
	AudioMODが導入されていると自分で用意した音声が使用できます。
	「SkinLoad」仕様のテクスチャを用意し、PlayerFormSkinLoad2.zipに追加するか、
	テクスチャパックに追加してcfgファイルの「useTexture=/mob/char_skin.png」の部分を適宜書き換えてください。



効能
	・プレーやモデルが「SkinLoadPlus」互換モデルに置き換わります。
	・プレーヤーに弱点を追加することが出来ます。
	・プレーヤーのダメージボイスを変更できます。
	・cfg設定で形状選択が出来ます。



設定項目
	isReplacePlayerControler = true/false	: PlayerAPIが導入されていない場合はTrueにしてください。

	isPhysical = true/false			:プレーヤの挙動変更を有効にするかを設定します。
	Physical_BurningPlayer = 0		:日光を浴びた場合の発火時間を設定します。ゾンビは８です。
	Physical_MeltingPlayer = 0		:濡れたときのダメージを設定します。エンダーマンは１です。
	Physical_Hammer = 1.0F			:水中での移動能力を設定します。０にすると水に浮きません、しかも移動も出来ません。
	Physical_Undead = fals			:プレーヤがアンデッドであるかを設定します。（PlayerAPI使用時は無効です）
	Physical_HurtSound="random.hurt"	:被ダメージ時の音声を設定します。（標準では「うぉ！」）
	
	isSkinLoad = true/false			:プレーヤーモデルの変更を有効にするかを設定します。
	SkinLoad_ModelFemale = true/false	:腕など体型がやや華奢にするかを設定します。
	SkinLoad_ModelHeadWare = true/false	:ヘッドウェア（スキンのヘルム部分）が頭に追従するようにするか設定します。
	SkinLoad_ModelInvertBlink = true/false	:瞬きテクスチャの動作を反転するか設定します。
	SkinLoad_ModelBustTypeA = true/false	:チッパイの追加を設定します。
	SkinLoad_ModelBustTypeB = true/false	:littleMaidModelのBrendaさんタイプのおっぱいの追加を設定します。
	SkinLoad_ModelSideTailL = true/false	:ツインテールの左側の表示を設定します。
	SkinLoad_ModelSideTailR = true/false	:ツインテールの右側の表示を設定します。
	SkinLoad_ModelPonytail = false/false	:ポニーテールが表示を設定します。部品テクスチャはツインテールと共通。
	SkinLoad_ModelLongHair = false/false	:背面ロングヘアの表示を設定します。部品テクスチャはツインテールと共通。
	SkinLoad_ModelChignon = true/false	:後頭部にお団子の表示を設定します。
	SkinLoad_ModelSkirt = true/false	:スカートの表示を設定します。
	SkinLoad_Texture = "/mob/char_skin.png"	:スキンとして使用する画像の設定、空白でアップロードしたスキン。



注意
	・バックアップはこまめに取りましょう。
	・単独動作します。
	・cfgの設定を行わなければキモイおっさんのままです。
	・「SkinLoad」対応テクスチャは自分で用意してください。
	・アップロードされたテクスチャの場合透過情報がおかしくなることがあるようです。



変更点
	20120412.1	1.2.5 Rev1 バージョンアップ



	20120326.1	1.2.4 Rev1 バージョンアップ
	20120312.1	1.2.3 Rev2 PlayerAPI対応
				アレ対応
	20120305.1	1.2.3 Rev1 バージョンアップ
	20120114.1	1.1.0 Rev1 バージョンアップ
	20120110.1	1.0.0 Rev2 修正
				ワールドセレクト画面からタイトルに戻れなかったのを修正
				金槌っぷりをより致命的に。
	20111205.1	1.0.0 Rev1 リリース、機能付加
	20111120.1	1.8.1 Rev1-plus リリース
	20111102.1	1.8.1 Rev1 リリース
