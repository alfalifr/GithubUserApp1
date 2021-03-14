package sidev.app.course.dicoding.bab3_modul1.github_user.model

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import sidev.lib.android.std.tool.util._ResUtil

data class User(
    val username: String,
    val name: String,
    val avatar: String,
    val company: String,
    val location: String,
    val repository: Int,
    val follower: Int,
    val following: Int,
): Parcelable {
    fun avatarInt(c: Context): Int = _ResUtil.getResId(c, avatar)

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of [.writeToParcel],
     * the return value of this method must include the
     * [.CONTENTS_FILE_DESCRIPTOR] bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    override fun describeContents(): Int = 0

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     * May be 0 or [.PARCELABLE_WRITE_RETURN_VALUE].
     */
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            writeString(username)
            writeString(name)
            writeString(avatar)
            writeString(company)
            writeString(location)
            writeInt(repository)
            writeInt(follower)
            writeInt(following)
        }
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}