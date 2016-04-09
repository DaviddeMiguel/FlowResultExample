# FlowResultExample
This project show a different approach to return a result between multiple activities.

Android provide us [**FLAG_ACTIVITY_FORWARD_RESULT**](http://developer.android.com/reference/android/content/Intent.html#FLAG_ACTIVITY_FORWARD_RESULT) and that is great, but you will find problems like:

- Need to finish the intermediate activities, otherwise the profile will not be delivered until the user closes the activity itself.

With this new approach, using the power of `startActivityForResult` and `onActivityResult` you will be able to:

- To have flows as long as you want, the user can go forward, back and forward as many times as it needs.
- To have sub-flows to get partial results.
