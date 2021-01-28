package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class StarParser {
	public List<Star> getList(String urlString){
		//作成したいlistをnew
		List<Star> list=new ArrayList<>();
		//スコープをあげるためここで宣言
		JsonReader reader=null;
		HttpURLConnection con=null;
		try {
			//urlの文字列からURLインスタンスを作成
			URL url=new URL(urlString);
			//openConnectionで接続
			con=(HttpURLConnection) url.openConnection();
			//GETによるリクエスト
			con.setRequestMethod("GET");
			//データ取得
			InputStream is=con.getInputStream();
			//スプーンからコップで効率化
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			//インプットストリームリーダーインスタンスからJsonReadrインスタンスを作成できる。
			reader=new JsonReader(isr);
			//GsonをnewしてfromJsonメソッドを用いてルート要素を取得する(今回ルートはオブジェクト)
			JsonObject root=new Gson().fromJson(reader, JsonObject.class);
			//root要素にあるresultプロパティを取得(配列)
			JsonArray result=root.get("result").getAsJsonArray();
			//配列とforは刺身と醤油。JsonArrayはsize()で要素数取得
			for(int i=0;i<result.size();i++){
				//Starインスタンスをnew
				Star star=new Star();
				//JsonArrayからはget(index)で要素を取得できる(オブジェクト)
				JsonObject sObj=result.get(i).getAsJsonObject();
				//取り出したオブジェクトの情報をStarインスタンスに詰める
				star.setEnName(sObj.get("enName").getAsString());
				star.setJpName(sObj.get("jpName").getAsString());
				star.setOrigin(sObj.get("origin").getAsString());
				star.setStarImage(sObj.get("starImage").getAsString());
				//Starインスタンスに全ての情報が入ったのでリストにadd
				list.add(star);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(con !=null){
				con.disconnect();
			}
		}
		return list;
	}
}


