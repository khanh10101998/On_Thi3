package hongkhanh.on_thi3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterMain extends BaseAdapter {
    Context context;
    ArrayList<Model> arrayList;

    public AdapterMain(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_list_main,null);
            holder = new ViewHolder();
            holder.ivAvatar = view.findViewById(R.id.iv_avatar);
            holder.tvAge = view.findViewById(R.id.tv_age);
            holder.tvName= view.findViewById(R.id.tv_name);
            holder.tvSex = view.findViewById(R.id.tv_sex);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        int image = context.getResources().getIdentifier(arrayList.get(i).getmAvatar(),"drawable",context.getPackageName());
        holder.ivAvatar.setImageResource(image);
        holder.tvAge.setText(arrayList.get(i).getmAge());
        holder.tvName.setText(arrayList.get(i).getmName());
        holder.tvSex.setText(arrayList.get(i).getmSex());

        return view;
    }

    private class ViewHolder{
        TextView tvName, tvAge, tvSex;
        ImageView ivAvatar;
    }

}
