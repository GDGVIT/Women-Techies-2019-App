package com.womentechmakers.wtmapp.Agenda;

public class AgendaData {

    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;

    public int type;
    public int data;
    public String text;

    public AgendaData(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }

    static String[] nameArray = {"Entry to the hack begins", "Expert Sessions and DSC's Project Display", "Dinner", "Crazy Coding 1.0" ,"Snacks", "Crazy Coding 2.0", "More Snacks", "Review 1", "Break", "Review 2", "Lunch Break", "Crazy Coding 3.0", "Pitch like a pro!", "Results"};

    static String[] timeArray = {"6:00 PM - 7:00PM", "7:00 PM - 8:00 PM", "9:30 PM - 10:30PM", "10:30 PM - 12:30AM","12:30 AM", "12:30 AM - 3:30 AM", "3:30 AM", "4:00 AM - 6:00AM", "6:00 AM - 10:00 AM", "10:00 AM - 1:00 PM", "1:00 PM - 2:00PM", "2:00 PM - 3:30 PM", "3:00 PM - 5:00 PM", "5:00PM - 6:00 PM"};


        static Integer[] id_ = { TEXT_TYPE,TEXT_TYPE,TEXT_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE,IMAGE_TYPE};

//    static Integer[] drawableArray = {R.drawable.ic_info_black_24dp, R.drawable.ic_info_black_24dp, R.drawable.ic_info_black_24dp,
//            R.drawable.ic_info_black_24dp, R.drawable.ic_info_black_24dp};

  //  static Integer[] id_ = {0, 1, 2, 3};
   // static Integer[] date = {0, 0, 1, 1};
}
