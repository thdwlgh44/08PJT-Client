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
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�
		////////////////////////////////////////////////////////////////////////////////////////////
		
		//Product Test
//		System.out.println("\n====================================\n");
//		// 1.1 Http Get ��� Request : JsonSimple lib ���
//		RestHttpClientApp2.getProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Get ��� Request : JsonSimple lib ���
//		RestHttpClientApp2.readProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Post ��� Request : JsonSimple lib ���
//		RestHttpClientApp2.addProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.1 Http Post ��� Request : JsonSimple lib ���
//		RestHttpClientApp2.updateProductTest_JsonSimple();
		
		System.out.println("\n====================================\n");
		// 1.1 Http Post ��� Request : JsonSimple lib ���
		RestHttpClientApp2.listProductTest_JsonSimple();
		
		
	}
	
//================================================================//
	
	public static void listProductTest_JsonSimple() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		// ==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
		public static void updateProductTest_JsonSimple() throws Exception {
			// HttpClient : Http Protocol �� client �߻�ȭ 
				HttpClient httpClient = new DefaultHttpClient();
					
				String url = "http://127.0.0.1:8080/product/json/updateProduct";
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json");
					
					//[ ��� 1 : String ���]
//						String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//						HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
					
					//[ ��� 2 : JSONObject ���]
					JSONObject json = new JSONObject();
					json.put("prodNo", "10001");
					json.put("prodName", "������ ����ȿ~");
					json.put("prodDetail", "������ǰ");
					json.put("manuDate", "20220515");
					json.put("price", "20000");
					json.put("fileName", "image");
					HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

					httpPost.setEntity(httpEntity01);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					
					//==> Response Ȯ��
					System.out.println(httpResponse);
					System.out.println();

					//==> Response �� entity(DATA) Ȯ��
					HttpEntity httpEntity = httpResponse.getEntity();
					
					//==> InputStream ����
					InputStream is = httpEntity.getContent();
					BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
					
					System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
					String serverData = br.readLine();
					System.out.println(serverData);
					
					//==> �����б�(JSON Value Ȯ��)
					JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
					System.out.println(jsonobj);
		}
	
	//1.1 Http Protocol POST Request : JsonSimple 3rd party lib ���
	public static void addProductTest_JsonSimple() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
				
			String url = "http://127.0.0.1:8080/product/json/addProduct";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
				
				//[ ��� 1 : String ���]
//					String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//					HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
				
				//[ ��� 2 : JSONObject ���]
				JSONObject json = new JSONObject();
				json.put("prodNo", "10027");
				json.put("prodName", "�ƺ�15");
				json.put("prodDetail", "������ǰ");
				json.put("manuDate", "20220420");
				json.put("price", "10000");
				json.put("fileName", "image");
				HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

				httpPost.setEntity(httpEntity01);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				//==> Response Ȯ��
				System.out.println(httpResponse);
				System.out.println();

				//==> Response �� entity(DATA) Ȯ��
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream ����
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
				String serverData = br.readLine();
				System.out.println(serverData);
				
				//==> �����б�(JSON Value Ȯ��)
				JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
				System.out.println(jsonobj);
	}
	
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void getProductTest_JsonSimple() throws Exception {
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
			HttpClient httpClient = new DefaultHttpClient();
				
			String url="http://127.0.0.1:8080/product/json/getProduct/{prodNo}";
						
			// HttpGet : Http Protocol �� GET ��� Request
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Accept", "application/json");
			httpGet.setHeader("Content-Type", "application/json");
				
			// HttpResponse : Http Protocol ���� Message �߻�ȭ
			HttpResponse httpResponse = httpClient.execute(httpGet);
				
			//==> Response Ȯ��
			System.out.println(httpResponse);
			System.out.println();

			//==> Response �� entity(DATA) Ȯ��
			HttpEntity httpEntity = httpResponse.getEntity();
				
			//==> InputStream ����
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
			System.out.println("[ Server���� ���� Data Ȯ�� ] ");
			String serverData = br.readLine();
			System.out.println(serverData);
				
			//==> �����б�(JSON Value Ȯ��)
			JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
			System.out.println(jsonobj);
	}
	
	public static void readProductTest_JsonSimple() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		
		String url="http://127.0.0.1:8080/product/json/readProduct/{prodNo}";
				
		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
}
	
	