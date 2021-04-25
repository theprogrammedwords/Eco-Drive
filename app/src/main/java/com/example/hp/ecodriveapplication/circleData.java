package com.example.hp.ecodriveapplication;


import java.util.ArrayList;
import java.util.Random;

public class circleData {

    String circleName, bioText, circleId, city, memberCount;
    int ImageId;
    public circleData(String circleName, String bioText, String circleId, String city, String memberCount, int ImageId) {
        this.circleName = circleName;
        this.bioText = bioText;
        this.circleId = circleId;
        this.city = city;
        this.memberCount = memberCount;
        this.ImageId = ImageId;

    }
    public int getImage() {
        return ImageId;
    }

    public void setImage(int ImageId) {
        this.ImageId = ImageId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getBioText() {
        return bioText;
    }

    public void setBioText(String bioText) {
        this.bioText = bioText;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(String  memberCount) {
        this.memberCount = memberCount;
    }



       public static ArrayList<circleData> createCircleData(int capacity)
       {
           capacity =12;

           Random random = new Random();
           String[] CircleText = new String[]{"GreenGroup", "United", "Go Green", "FootPrintSavers", "GoodWill",
                   "Ecovators", "Corona", "GreenAmbassadors", "CarburnLess", "GreenPolicy","Create Circle", "Explore Circles"};

           String[] bioText = new String[]{"EverGreens", "United for charge", "Go Green", "FootPrintSavers !!", "GoodWill Green Tribe",
                   "Ecovators for you !", "Corona, a star of society.", "GreenAmbassadors !", "CarburnLess.", "GreenPolicy, for us.", "", ""};

           String[] cityText = new String[]{"Nagpur", "Chennai", "Hubali", "Trevandrum", "Jammu",
                   "Nagpur", "Pune", "Mumbai", "Yavatmal", "Satara", "", ""};

           int[] ImageId = new int[]{R.drawable.ic_circles,R.drawable.ic_circles,R.drawable.ic_circles,R.drawable.ic_circles,
                   R.drawable.ic_circles,R.drawable.ic_circles,R.drawable.ic_circles,R.drawable.ic_circles,
                   R.drawable.ic_circles,R.drawable.ic_circles,R.drawable.ic_circles,R.drawable.ic_circles,};

           ArrayList<circleData> circleDataArrayItem = new ArrayList<circleData>();
           for (int i=0; i<capacity; i++ )
           {
               circleDataArrayItem.add(new circleData(CircleText[i], bioText[i], "C"+i, cityText[i],""+random.nextInt(20), ImageId[i]));
           }
           return circleDataArrayItem;
       }


}
