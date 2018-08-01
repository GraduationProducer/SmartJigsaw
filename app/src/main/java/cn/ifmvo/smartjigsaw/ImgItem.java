package cn.ifmvo.smartjigsaw;

/*
 * (●ﾟωﾟ●) 拼图的每一块
 *
 * Created by Matthew_Chen on 2018/7/31.
 */
public class ImgItem
{
    public int x;
    public int y;
    public int imgResId;
    public int position;//应该在的位置


    public ImgItem(int x, int y, int imgResId, int position)
    {
        this.x = x;
        this.y = y;
        this.imgResId = imgResId;
        this.position = position;
    }
}
