package bean;
//java.io.Serializableクラスを実装する
public class Product implements java.io.Serializable {
	//メンバ変数
	private int id; //商品番号
	private String name; //商品名
	private int price; //価格

	//メソッド
	//ゲッター
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	//セッター
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
}
