package com.example.arturmusayelyan.jsonexample1;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by artur.musayelyan on 20/11/2017.
 */

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Product> expandableList;

    public CustomExpandableListAdapter(Context context, List<Product> expandableList) {
        this.context = context;
        this.expandableList = expandableList;
    }

    @Override
    public int getGroupCount() {
        return this.expandableList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // return this.expandableList.get(this.expandableList.get(groupPosition).getChildrensProductList().size());
        return this.expandableList.get(groupPosition).getChildrensProductList().size();// ?
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.expandableList.get(groupPosition).getName();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {  //?
        return this.expandableList.get(groupPosition).getChildrensProductList().get(childPosition).getName();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView tv_groupTitle = convertView.findViewById(R.id.group_title_tv);
        tv_groupTitle.setTypeface(null, Typeface.BOLD);
        tv_groupTitle.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childItemText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView tv_childItem = convertView.findViewById(R.id.child_item_tv);
        tv_childItem.setText(childItemText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
