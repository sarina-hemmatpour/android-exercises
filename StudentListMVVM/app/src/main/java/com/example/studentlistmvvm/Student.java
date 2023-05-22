package com.example.studentlistmvvm;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Student implements Parcelable {

	@SerializedName("score")
	private int score;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("course")
	private String course;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setCourse(String course){
		this.course = course;
	}

	public String getCourse(){
		return course;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.score);
		dest.writeString(this.lastName);
		dest.writeString(this.course);
		dest.writeInt(this.id);
		dest.writeString(this.firstName);
	}

	public void readFromParcel(Parcel source) {
		this.score = source.readInt();
		this.lastName = source.readString();
		this.course = source.readString();
		this.id = source.readInt();
		this.firstName = source.readString();
	}

	public Student() {
	}

	protected Student(Parcel in) {
		this.score = in.readInt();
		this.lastName = in.readString();
		this.course = in.readString();
		this.id = in.readInt();
		this.firstName = in.readString();
	}

	public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
		@Override
		public Student createFromParcel(Parcel source) {
			return new Student(source);
		}

		@Override
		public Student[] newArray(int size) {
			return new Student[size];
		}
	};
}