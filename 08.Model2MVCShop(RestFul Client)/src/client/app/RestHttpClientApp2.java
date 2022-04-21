package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


//Product ClientApp
public class RestHttpClientApp2 {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// 주석을 하나씩 처리해가며 실습
		////////////////////////////////////////////////////////////////////////////////////////////
		
		//Product Test
//		System.out.println("\n====================================\n");
//		// 1.1 Http Get 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp2.getProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Get 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp2.readProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Post 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp2.addProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Post 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp2.updateProductTest_JsonSimple();
		
		System.out.println("\n====================================\n");
		// 1.1 Http Post 방식 Request : JsonSimple lib 사용
		RestHttpClientApp2.listProductTest_JsonSimple();
		
		
	}
	
//================================================================//
	
	public static void listProductTest_JsonSimple() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		// ==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		// ==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
		public static void updateProductTest_JsonSimple() throws Exception {
			// HttpClient : Http Protocol 의 client 추상화 
				HttpClient httpClient = new DefaultHttpClient();
					
				String url = "http://127.0.0.1:8080/product/json/updateProduct";
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json");
					
					//[ 방법 1 : String 사용]
//						String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//						HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
					
					//[ 방법 2 : JSONObject 사용]
					JSONObject json = new JSONObject();
					json.put("prodNo", "10001");
					json.put("prodName", "자전거 좋아효~");
					json.put("prodDetail", "애플제품");
					json.put("manuDate", "20220515");
					json.put("price", "20000");
					json.put("fileName", "image");
					HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

					httpPost.setEntity(httpEntity01);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					
					//==> Response 확인
					System.out.println(httpResponse);
					System.out.println();

					//==> Response 중 entity(DATA) 확인
					HttpEntity httpEntity = httpResponse.getEntity();
					
					//==> InputStream 생성
					InputStream is = httpEntity.getContent();
					BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
					
					System.out.println("[ Server 에서 받은 Data 확인 ] ");
					String serverData = br.readLine();
					System.out.println(serverData);
					
					//==> 내용읽기(JSON Value 확인)
					JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
					System.out.println(jsonobj);
		}
	
	//1.1 Http Protocol POST Request : JsonSimple 3rd party lib 사용
	public static void addProductTest_JsonSimple() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화 
			HttpClient httpClient = new DefaultHttpClient();
				
			String url = "http://127.0.0.1:8080/product/json/addProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
				
				//[ 방법 1 : String 사용]
//					String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//					HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
				
				//[ 방법 2 : JSONObject 사용]
				JSONObject json = new JSONObject();
				json.put("prodNo", "10027");
				json.put("prodName", "맥북15");
				json.put("prodDetail", "애플제품");
				json.put("manuDate", "20220420");
				json.put("price", "10000");
				json.put("fileName", "image");
				HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

				httpPost.setEntity(httpEntity01);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				//==> Response 확인
				System.out.println(httpResponse);
				System.out.println();

				//==> Response 중 entity(DATA) 확인
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream 생성
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				System.out.println("[ Server 에서 받은 Data 확인 ] ");
				String serverData = br.readLine();
				System.out.println(serverData);
				
				//==> 내용읽기(JSON Value 확인)
				JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
				System.out.println(jsonobj);
	}
	
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void getProductTest_JsonSimple() throws Exception {
		
		// HttpClient : Http Protocol 의 client 추상화 
			HttpClient httpClient = new DefaultHttpClient();
				
			String url="http://127.0.0.1:8080/product/json/getProduct/{prodNo}";
						
			// HttpGet : Http Protocol 의 GET 방식 Request
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Accept", "application/json");
			httpGet.setHeader("Content-Type", "application/json");
				
			// HttpResponse : Http Protocol 응답 Message 추상화
			HttpResponse httpResponse = httpClient.execute(httpGet);
				
			//==> Response 확인
			System.out.println(httpResponse);
			System.out.println();

			//==> Response 중 entity(DATA) 확인
			HttpEntity httpEntity = httpResponse.getEntity();
				
			//==> InputStream 생성
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
			System.out.println("[ Server에서 받은 Data 확인 ] ");
			String serverData = br.readLine();
			System.out.println(serverData);
				
			//==> 내용읽기(JSON Value 확인)
			JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
			System.out.println(jsonobj);
	}
	
	public static void readProductTest_JsonSimple() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		
		String url="http://127.0.0.1:8080/product/json/readProduct/{prodNo}";
				
		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
}
	
	