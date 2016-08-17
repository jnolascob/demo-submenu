package me.doapps.demosubmenu;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private android.app.Fragment fragment = null;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    static int[] icon = {R.mipmap.ic_home, R.mipmap.ic_people,
            R.mipmap.ic_photos, R.mipmap.ic_communities,
            R.mipmap.ic_pages, R.mipmap.ic_whats_hot, R.mipmap.ic_home,
            R.mipmap.ic_people, R.mipmap.ic_photos,
            R.mipmap.ic_communities, R.mipmap.ic_pages};
    View view_Group;

    private Toolbar toolbar;

    private CharSequence mDrawerTitle;

    private CharSequence mTitle;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = mDrawerTitle = getTitle();

        setUpDrawer();

        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };


        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }


    /**
     * Get the names and icons references to build the drawer menu...
     */
    private void setUpDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerListener);
        expListView = (ExpandableListView) findViewById(R.id.list_slidermenu);
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader,
                listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                v.setSelected(true);
                if (view_Group != null) {
                    view_Group.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                view_Group = v;
                view_Group.setBackgroundColor(Color.parseColor("#F21E1E"));

                switch (groupPosition) {

                    case 0:
                        fragment = new FirstFragment();
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                fragment = new FirstFragment();
                                break;
                            case 1:
                                fragment = new FirstFragment();
                                break;

                            default:
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                fragment = new FirstFragment();
                                break;
                            case 1:
                                fragment = new FirstFragment();
                                break;
                            case 2:
                                fragment = new FirstFragment();
                                break;

                            default:
                                break;
                        }
                        break;
                    case 3:
                        switch (childPosition) {

                            case 0:
                                fragment = new FirstFragment();
                                break;
                            case 1:
                                fragment = new FirstFragment();
                                break;
                            case 2:
                                fragment = new FirstFragment();
                                break;

                            default:
                                break;
                        }
                        break;
                    case 4:
                        switch (childPosition) {
                            case 0:
                                fragment = new FirstFragment();
                                break;
                            case 1:
                                fragment = new FirstFragment();
                                break;
                            case 2:
                                fragment = new FirstFragment();
                                break;

                            default:
                                break;
                        }
                        break;
                    case 5:
                        switch (childPosition) {
                            case 0:
                                fragment = new FirstFragment();
                                break;
                            case 1:
                                fragment = new FirstFragment();
                                break;

                            default:
                                break;
                        }
                        break;
                    case 6:
                        switch (childPosition) {
                            case 0:
                                fragment = new FirstFragment();
                                break;
                            case 1:
                                fragment = new FirstFragment();
                                break;
                            case 2:
                                fragment = new FirstFragment();
                                break;

                            default:
                                break;
                        }
                        break;

                    case 7:
                        fragment = new FirstFragment();

                    default:
                        break;
                }
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
                expListView.setItemChecked(childPosition, true);
                mDrawerLayout.closeDrawer(expListView);
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {

        @Override
        public void onDrawerStateChanged(int status) {

        }

        @Override
        public void onDrawerSlide(View view, float slideArg) {

        }

        @Override
        public void onDrawerOpened(View view) {
            getActionBar().setTitle(mDrawerTitle);
            invalidateOptionsMenu();
        }

        @Override
        public void onDrawerClosed(View view) {
            getActionBar().setTitle(mTitle);
            invalidateOptionsMenu();
        }
    };

    /**Load data**/
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        String[] array = getResources()
                .getStringArray(R.array.nav_drawer_items);
        listDataHeader = Arrays.asList(array);

        List<String> dashboard = new ArrayList<String>();
        String[] dash = getResources().getStringArray(R.array.dash_board);
        dashboard = Arrays.asList(dash);

        List<String> l1 = new ArrayList<String>();
        String[] before = getResources()
                .getStringArray(R.array.before_you_file);
        l1 = Arrays.asList(before);

        List<String> l2 = new ArrayList<String>();
        String[] myproe = getResources().getStringArray(R.array.my_profile);
        l2 = Arrays.asList(myproe);

        List<String> l3 = new ArrayList<String>();
        String[] inco = getResources().getStringArray(R.array.income_slip);
        l3 = Arrays.asList(inco);

        List<String> l4 = new ArrayList<String>();
        String[] fed = getResources().getStringArray(R.array.federal_deduction);
        l4 = Arrays.asList(fed);

        List<String> l5 = new ArrayList<String>();
        String[] provi = getResources().getStringArray(
                R.array.provincial_credit);
        l5 = Arrays.asList(provi);

        List<String> l6 = new ArrayList<String>();
        String[] expen = getResources().getStringArray(R.array.expenses);
        l6 = Arrays.asList(expen);

        List<String> l7 = new ArrayList<String>();
        String[] revieww = getResources().getStringArray(R.array.review);
        l7 = Arrays.asList(revieww);

        List<String> l8 = new ArrayList<String>();

        List<String> l9 = new ArrayList<String>();

        List<String> l10 = new ArrayList<String>();

        listDataChild.put(listDataHeader.get(0), dashboard);

        listDataChild.put(listDataHeader.get(1), l1);
        listDataChild.put(listDataHeader.get(2), l2);
        listDataChild.put(listDataHeader.get(3), l3);
        listDataChild.put(listDataHeader.get(4), l4);
        listDataChild.put(listDataHeader.get(5), l5);
        listDataChild.put(listDataHeader.get(6), l6);
        listDataChild.put(listDataHeader.get(7), l7);
        listDataChild.put(listDataHeader.get(8), l8);
        listDataChild.put(listDataHeader.get(9), l9);
        listDataChild.put(listDataHeader.get(10), l10);
    }


    /**Adapter**/
    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private Context _context;
        private List<String> _listDataHeader;
        private HashMap<String, List<String>> _listDataChild;

        public ExpandableListAdapter(Context context,
                                     List<String> listDataHeader,
                                     HashMap<String, List<String>> listChildData) {
            this._context = context;
            this._listDataHeader = listDataHeader;
            this._listDataChild = listChildData;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this._listDataChild.get(
                    this._listDataHeader.get(groupPosition))
                    .get(childPosititon);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            final String childText = (String) getChild(groupPosition,
                    childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_item, null);
            }

            TextView txtListChild = (TextView) convertView
                    .findViewById(R.id.lblListItem);

            txtListChild.setText(childText);
            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return this._listDataChild.get(
                    this._listDataHeader.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this._listDataHeader.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_group, null);
            }
            TextView txt_plusminus = (TextView) convertView
                    .findViewById(R.id.plus_txt);
            if (isExpanded) {
                txt_plusminus.setText("-");
            } else {
                txt_plusminus.setText("+");
            }

            TextView lblListHeader = (TextView) convertView
                    .findViewById(R.id.lblListHeader);
            lblListHeader.setTypeface(null, Typeface.BOLD);
            lblListHeader.setText(headerTitle);

            ImageView imgListGroup = (ImageView) convertView
                    .findViewById(R.id.ic_txt);
            imgListGroup.setImageResource(MainActivity.icon[groupPosition]);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
