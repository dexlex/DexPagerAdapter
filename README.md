# ![Logo](/assets/images/dpa.png) DexPagerAdapter

DPA aims to provide a flexible and customizable instrument for automated updated of adjacent instantiated view or fragment for a ViewPager Adapter.

# Features
 * Developed for both PagerAdapter and FragmentStatePagerAdapter
 * Android 1.5+ support

# Downloads
[![Demo app](assets/images/android-app-on-google-play.png)](https://play.google.com/store/apps/details?id=it.dex.dexpageradapter)

![Screenshot](/assets/screenshot/pager_adapter.png)
![Screenshot](/assets/screenshot/menu.png)

# Setup

DexPagerAdapter is pushed to Maven Central as an AAR. Add the following to build.gradle.

```gradle
    dependencies {
        compile 'it.dex.dexpageradapter:dexpageradapterlib:0.1.0'
    }
```

or the following using Maven:

```xml
    <dependency>
        <groupid>it.dex.dexpageradapter</groupid>
        <artifactid>dexpageradapterlib</artifactid>
        <version>0.1.0</version>
        <type>aar</type>
    </dependency>
```

# Usage

This section show you how to use the provided views without questioning how it works.

This library provides 2 PagerAdapter to be extended:

 * DexPagerAdapter
 * DexFragmentStatePagerAdapter

## DexPagerAdater

It has 2 abstract methods you must implement:

```java
    public View getView(int position, ViewPager viewPager);
    public void updateAddedItems(View view, int position);
```

The first one replace the PagerAdapter.instantiateItem(ViewGroup container, int position) method.
The second one is used to update all the instantiated and added Views to the ViewPager. Every time a ViewPager.notifyDataSetChanged() method is called,
the updateAddedItems is called for all ViewPager added views. This helps you change or update UI of adjacent pages.

Ex.
```java
    @Override
    public void updateAddedItems(View view, int position) {
        TextView text = (TextView) view.findViewById(R.id.text_view);
        text.setText(text);
    }
```

## DexFragmentStatePagerAdater

It uses Generics to update the same type of Fragment.
It has 2 abstract methods you must implement:

```java
    public abstract T getFragment(int position);
    public void updateAddedItems(T fragment, int position);
```

The first one replace the FragmentStatePagerAdapter.getItem(int position) method.
The second one is used to update all the instantiated and added Fragment to the ViewPager. Every time a ViewPager.notifyDataSetChanged() method is called,
the updateAddedItems is called for all ViewPager added fragments. This helps you change or update UI of adjacent fragment pages.

Ex.
```java
    @Override
    public void updateAddedItems(ItemFragment itemFragment, int position) {
        itemFragment.doSomething();
    }
```

Credits
-------

Author: Diego Grancini (dexlex84@gmail.com)

Any hint, suggestion, improvement or comment will be appreciated

<a href="https://plus.google.com/u/0/+DiegoGrancini/posts">
  <img alt="Follow me on Google+"
       src="/assets/images/google.png" />
</a>
<a href="https://twitter.com/DiegoGrancini">
  <img alt="Follow me on Twitter"
       src="/assets/images/twitter.png" />
</a>
<a href="http://it.linkedin.com/in/diegograncini">
      <img alt="Follow me on LinkedIn"
           src="/assets/images/linkedin.png" />
</a>
<a href="https://github.com/dexlex/DexPagerAdapter">
     <img alt="Follow me on GitHub"
           src="/assets/images/github.png" />
</a>


# License

    Copyright 2014-2015 Diego Grancini

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.