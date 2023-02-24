package DreamShop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="slides")
public class SlidesEntity extends BaseEntity{
	@Column(name="img")
	private String img;
	@Column(name="caption",columnDefinition="text")
	private String caption;
	@Column(name="content",columnDefinition="text")
	private String content;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
