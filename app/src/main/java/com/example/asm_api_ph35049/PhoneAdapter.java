package com.example.asm_api_ph35049;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhoneAdapter extends BaseAdapter {

    List<PhoneModel> phoneModelList;

    Context context;

    public PhoneAdapter (Context context, List<PhoneModel> phoneModelList) {
        this.context = context;
        this.phoneModelList = phoneModelList;
    }

    @Override
    public int getCount() {
        return phoneModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return phoneModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_phone, viewGroup, false);

        TextView tvID = (TextView) rowView.findViewById(R.id.tvId);
        ImageView imgAvatar = (ImageView) rowView.findViewById(R.id.imgAvatatr);
        TextView tvName = (TextView) rowView.findViewById(R.id.tvName);

        TextView tvNamSX = (TextView) rowView.findViewById(R.id.tvNamSX);

        TextView tvHang = (TextView) rowView.findViewById(R.id.tvHang);

        TextView tvGia = (TextView) rowView.findViewById(R.id.tvGia);

//        String imageUrl = mList.get(position).getThumbnailUrl();
//        Picasso.get().load(imageUrl).into(imgAvatar);
////        imgAvatar.setImageResource(imageId[position]);
        tvName.setText(String.valueOf(phoneModelList.get(position).getTen()));

        tvNamSX.setText(String.valueOf(phoneModelList.get(position).getNamSX()));

        tvHang.setText(String.valueOf(phoneModelList.get(position).getHang()));

        tvGia.setText(String.valueOf(phoneModelList.get(position).getGia()));

        return rowView;
    }


}
