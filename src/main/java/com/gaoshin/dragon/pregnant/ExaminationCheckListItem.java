package com.gaoshin.dragon.pregnant;

public class ExaminationCheckListItem {
	public int startWeek;
	public int endWeek;
	public String title;
	public String content;
	
	public ExaminationCheckListItem() {
	}
	
	public ExaminationCheckListItem(int startWeek, int endWeek, String title, String content) {
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.title = title;
		this.content = content;
	}
	
}
