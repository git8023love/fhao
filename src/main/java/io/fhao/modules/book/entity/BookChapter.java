package io.fhao.modules.book.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hgw
 * @Description: TODO(章节表)
 * @date 2018-08-08 14:04:23
 */
public class BookChapter implements Serializable {
	
	//小说章节
	private Long id;
	//小说Id
	private Long noveid;
	//章节名
	private String name;
	//第几章
	private Long chaptersort;
	//章节内容
	private String chaptercontext;

	/**
	 * 设置：小说章节
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：小说章节
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：小说Id
	 */
	public void setNoveid(Long noveid) {
		this.noveid = noveid;
	}
	/**
	 * 获取：小说Id
	 */
	public Long getNoveid() {
		return noveid;
	}
	/**
	 * 设置：章节名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：章节名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：第几章
	 */
	public void setChaptersort(Long chaptersort) {
		this.chaptersort = chaptersort;
	}
	/**
	 * 获取：第几章
	 */
	public Long getChaptersort() {
		return chaptersort;
	}
	/**
	 * 设置：章节内容
	 */
	public void setChaptercontext(String chaptercontext) {
		this.chaptercontext = chaptercontext;
	}
	/**
	 * 获取：章节内容
	 */
	public String getChaptercontext() {
		return chaptercontext;
	}

}
