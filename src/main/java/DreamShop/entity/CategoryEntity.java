package DreamShop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
		@Column(name = "name")
		private String name;

		@Column(name = "code")
		private String code;

		@OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
		private List<ProductEntity> news ;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public List<ProductEntity> getNews() {
			return news;
		}

		public void setNews(List<ProductEntity> news) {
			this.news = news;
		}

		
		
		
}
