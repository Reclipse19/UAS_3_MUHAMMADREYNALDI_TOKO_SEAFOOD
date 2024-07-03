package com.example.lastchance.main;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ModelCategories implements Parcelable {
    private final int iIcon;
    private final String strName;

    /**
     * Constructor to initialize category with an icon and name.
     *
     * @param iIcon Resource ID for the icon.
     * @param strName Name of the category.
     */
    public ModelCategories(int iIcon, String strName) {
        if (iIcon <= 0) {
            throw new IllegalArgumentException("Icon ID must be positive.");
        }
        if (strName == null || strName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.iIcon = iIcon;
        this.strName = strName;
    }

    public int getiIcon() {
        return iIcon;
    }

    public String getStrName() {
        return strName;
    }

    // Optional: Override equals and hashCode for comparison and hash-based collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelCategories that = (ModelCategories) o;

        if (iIcon != that.iIcon) return false;
        return strName.equals(that.strName);
    }

    @Override
    public int hashCode() {
        int result = iIcon;
        result = 31 * result + strName.hashCode();
        return result;
    }

    // Optional: Override toString for better logging and debugging
    @NonNull
    @Override
    public String toString() {
        return "ModelCategories{" +
                "iIcon=" + iIcon +
                ", strName='" + strName + '\'' +
                '}';
    }
    protected ModelCategories(Parcel in) {
        iIcon = in.readInt();
        strName = in.readString();
    }

    public static final Creator<ModelCategories> CREATOR = new Creator<ModelCategories>() {
        @Override
        public ModelCategories createFromParcel(Parcel in) {
            return new ModelCategories(in);
        }

        @Override
        public ModelCategories[] newArray(int size) {
            return new ModelCategories[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(iIcon);
        dest.writeString(strName);
    }
}
