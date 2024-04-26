package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
//ProductDAOクラスはDAOクラスを継承している
public class ProductDAO extends DAO {

	public List<Product> search(String keyword) throws Exception {
		List<Product> list=new ArrayList<>();
		//親クラスのgetConnectionメソッドを呼び出す
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from product where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Product p=new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}
		//DB接続を切るおまじない
		st.close();
		con.close();

		return list;
	}

	public int insert(Product product) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into product values(null, ?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
