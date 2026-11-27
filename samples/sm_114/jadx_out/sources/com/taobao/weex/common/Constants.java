package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class Constants {

    public interface CodeCache {
        public static final java.lang.String BANNER_DIGEST = "digest";
        public static final java.lang.String DIGEST = "bundleDigest";
        public static final java.lang.String PATH = "codeCachePath";
        public static final java.lang.String SAVE_PATH = "v8";
        public static final java.lang.String URL = "bundleUrl";
    }

    public interface Event {
        public static final java.lang.String APPEAR = "appear";
        public static final java.lang.String BLUR = "blur";
        public static final java.lang.String CHANGE = "change";
        public static final java.lang.String CLICK = "click";
        public static final java.lang.String CLICKBACKITEM = "clickbackitem";
        public static final java.lang.String DISAPPEAR = "disappear";
        public static final java.lang.String ERROR = "error";
        public static final java.lang.String FAIL = "fail";
        public static final java.lang.String FINISH = "finish";
        public static final java.lang.String FOCUS = "focus";
        public static final java.lang.String INPUT = "input";
        public static final java.lang.String KEYBOARD = "keyboard";
        public static final java.lang.String LAYEROVERFLOW = "layeroverflow";
        public static final java.lang.String LOADMORE = "loadmore";
        public static final java.lang.String NATIVE_BACK = "nativeback";
        public static final java.lang.String ONLOAD = "load";
        public static final java.lang.String ONLOADING = "loading";
        public static final java.lang.String ONMESSAGE = "message";
        public static final java.lang.String ONPULLING_DOWN = "pullingdown";
        public static final java.lang.String ONPULLING_UP = "pullingup";
        public static final java.lang.String ONREFRESH = "refresh";
        public static final java.lang.String ON_TRANSITION_END = "transitionEnd";
        public static final java.lang.String PAGEFINISH = "pagefinish";
        public static final java.lang.String PAGESTART = "pagestart";
        public static final java.lang.String PAUSE = "pause";
        public static final java.lang.String PAUSE_EVENT = "WXApplicationWillResignActiveEvent";
        public static final java.lang.String RECEIVEDTITLE = "receivedtitle";
        public static final java.lang.String RESUME_EVENT = "WXApplicationDidBecomeActiveEvent";
        public static final java.lang.String RETURN = "return";
        public static final java.lang.String SCROLL = "scroll";
        public static final java.lang.String SCROLL_END = "scrollend";
        public static final java.lang.String SCROLL_START = "scrollstart";
        public static final java.lang.String START = "start";
        public static final java.lang.String STICKY = "sticky";
        public static final java.lang.String STOP_PROPAGATION = "stopPropagation";
        public static final java.lang.String STOP_PROPAGATION_RAX = "stoppropagation";
        public static final java.lang.String UNSTICKY = "unsticky";
        public static final java.lang.String VIEWAPPEAR = "viewappear";
        public static final java.lang.String VIEWDISAPPEAR = "viewdisappear";

        public interface SLOT_LIFECYCLE {
            public static final java.lang.String ATTACH = "attach";
            public static final java.lang.String CREATE = "create";
            public static final java.lang.String DESTORY = "destroy";
            public static final java.lang.String DETACH = "detach";
        }
    }

    public interface Name {
        public static final java.lang.String ALIGN_ITEMS = "alignItems";
        public static final java.lang.String ALIGN_SELF = "alignSelf";
        public static final java.lang.String ALLOW_COPY_PASTE = "allowCopyPaste";
        public static final java.lang.String ANIMATED = "animated";
        public static final java.lang.String ANIMATING = "animating";
        public static final java.lang.String ARIA_HIDDEN = "ariaHidden";
        public static final java.lang.String ARIA_LABEL = "ariaLabel";
        public static final java.lang.String AUTO = "auto";
        public static final java.lang.String AUTOFOCUS = "autofocus";
        public static final java.lang.String AUTOPLAY = "autoplay";
        public static final java.lang.String AUTO_PLAY = "autoPlay";
        public static final java.lang.String AUTO_RECYCLE = "autoBitmapRecycle";
        public static final java.lang.String BACKGROUND_COLOR = "backgroundColor";
        public static final java.lang.String BACKGROUND_IMAGE = "backgroundImage";
        public static final java.lang.String BORDER_BOTTOM_COLOR = "borderBottomColor";
        public static final java.lang.String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
        public static final java.lang.String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
        public static final java.lang.String BORDER_BOTTOM_STYLE = "borderBottomStyle";
        public static final java.lang.String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
        public static final java.lang.String BORDER_COLOR = "borderColor";
        public static final java.lang.String BORDER_LEFT_COLOR = "borderLeftColor";
        public static final java.lang.String BORDER_LEFT_STYLE = "borderLeftStyle";
        public static final java.lang.String BORDER_LEFT_WIDTH = "borderLeftWidth";
        public static final java.lang.String BORDER_RADIUS = "borderRadius";
        public static final java.lang.String BORDER_RIGHT_COLOR = "borderRightColor";
        public static final java.lang.String BORDER_RIGHT_STYLE = "borderRightStyle";
        public static final java.lang.String BORDER_RIGHT_WIDTH = "borderRightWidth";
        public static final java.lang.String BORDER_STYLE = "borderStyle";
        public static final java.lang.String BORDER_TOP_COLOR = "borderTopColor";
        public static final java.lang.String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
        public static final java.lang.String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
        public static final java.lang.String BORDER_TOP_STYLE = "borderTopStyle";
        public static final java.lang.String BORDER_TOP_WIDTH = "borderTopWidth";
        public static final java.lang.String BORDER_WIDTH = "borderWidth";
        public static final java.lang.String BOTTOM = "bottom";
        public static final java.lang.String BOUNCE = "bounce";
        public static final java.lang.String BOX_SHADOW = "boxShadow";
        public static final java.lang.String CHECKED = "checked";
        public static final java.lang.String COLOR = "color";
        public static final java.lang.String COLUMN_COUNT = "columnCount";
        public static final java.lang.String COLUMN_GAP = "columnGap";
        public static final java.lang.String COLUMN_WIDTH = "columnWidth";
        public static final java.lang.String CONTENT_OFFSET = "contentOffset";
        public static final java.lang.String CONTENT_SIZE = "contentSize";
        public static final java.lang.String CONTROLS = "controls";
        public static final java.lang.String DEFAULT_HEIGHT = "defaultHeight";
        public static final java.lang.String DEFAULT_WIDTH = "defaultWidth";
        public static final java.lang.String DELETE_CELL_ANIMATION = "deleteAnimation";
        public static final java.lang.String DIRECTION = "direction";
        public static final java.lang.String DISABLED = "disabled";
        public static final java.lang.String DISPLAY = "display";
        public static final java.lang.String DISTANCE_Y = "dy";
        public static final java.lang.String DRAGGABLE = "draggable";
        public static final java.lang.String ELEVATION = "elevation";
        public static final java.lang.String ELLIPSIS = "ellipsis";
        public static final java.lang.String ENABLE_COPY = "enableCopy";
        public static final java.lang.String FILTER = "filter";
        public static final java.lang.String FLAT = "flat";
        public static final java.lang.String FLEX = "flex";
        public static final java.lang.String FLEX_DIRECTION = "flexDirection";
        public static final java.lang.String FLEX_WRAP = "flexWrap";
        public static final java.lang.String FONT_FACE = "fontFace";
        public static final java.lang.String FONT_FAMILY = "fontFamily";
        public static final java.lang.String FONT_SIZE = "fontSize";
        public static final java.lang.String FONT_STYLE = "fontStyle";
        public static final java.lang.String FONT_WEIGHT = "fontWeight";
        public static final java.lang.String HAS_FIXED_SIZE = "hasFixedSize";
        public static final java.lang.String HEIGHT = "height";
        public static final java.lang.String HREF = "href";
        public static final java.lang.String IMAGE_QUALITY = "imageQuality";
        public static final java.lang.String IMAGE_SHARPEN = "imageSharpen";
        public static final java.lang.String INCLUDE_FONT_PADDING = "includeFontPadding";
        public static final java.lang.String INDEX = "index";
        public static final java.lang.String INSERT_CELL_ANIMATION = "insertAnimation";
        public static final java.lang.String INTERVAL = "interval";
        public static final java.lang.String ISDRAGGING = "isDragging";
        public static final java.lang.String ITEM_COLOR = "itemColor";
        public static final java.lang.String ITEM_SELECTED_COLOR = "itemSelectedColor";
        public static final java.lang.String ITEM_SIZE = "itemSize";
        public static final java.lang.String JUSTIFY_CONTENT = "justifyContent";
        public static final java.lang.String KEEP_INDEX = "keepIndex";
        public static final java.lang.String KEEP_POSITION_LAYOUT_DELAY = "keepPositionLayoutDelay";
        public static final java.lang.String KEEP_SCROLL_POSITION = "keepScrollPosition";
        public static final java.lang.String KEEP_SELECTION_INDEX = "keepSelectionIndex";
        public static final java.lang.String LAYERLIMIT = "layerLimit";
        public static final java.lang.String LAYER_LIMIT = "layer-limit";
        public static final java.lang.String LAYOUT = "layout";
        public static final java.lang.String LEFT = "left";
        public static final java.lang.String LEFT_GAP = "leftGap";
        public static final java.lang.String LINES = "lines";
        public static final java.lang.String LINE_HEIGHT = "lineHeight";
        public static final java.lang.String LOADMOREOFFSET = "loadmoreoffset";
        public static final java.lang.String LOADMORERETRY = "loadmoreretry";
        public static final java.lang.String MARGIN = "margin";
        public static final java.lang.String MARGIN_BOTTOM = "marginBottom";
        public static final java.lang.String MARGIN_LEFT = "marginLeft";
        public static final java.lang.String MARGIN_RIGHT = "marginRight";
        public static final java.lang.String MARGIN_TOP = "marginTop";
        public static final java.lang.String MAX = "max";
        public static final java.lang.String MAXLENGTH = "maxlength";
        public static final java.lang.String MAX_HEIGHT = "maxHeight";
        public static final java.lang.String MAX_LENGTH = "maxLength";
        public static final java.lang.String MAX_WIDTH = "maxWidth";
        public static final java.lang.String MIN = "min";
        public static final java.lang.String MIN_HEIGHT = "minHeight";
        public static final java.lang.String MIN_WIDTH = "minWidth";
        public static final java.lang.String MODE = "mode";
        public static final java.lang.String NAV_BAR_VISIBILITY = "hidden";
        public static final java.lang.String NEST_SCROLLING_ENABLED = "nestedScrollingEnabled";
        public static final java.lang.String NORMAL = "normal";
        public static final java.lang.String OFFSET = "offset";
        public static final java.lang.String OFFSET_ACCURACY = "offsetAccuracy";
        public static final java.lang.String OFFSET_X_ACCURACY = "offsetXAccuracy";
        public static final java.lang.String OFFSET_X_RATIO = "offsetXRatio";
        public static final java.lang.String OPACITY = "opacity";
        public static final java.lang.String ORIENTATION = "orientation";
        public static final java.lang.String OVERFLOW = "overflow";
        public static final java.lang.String OVERFLOW_HIDDEN_HEIGHT = "overflowHiddenHeight";
        public static final java.lang.String OVERFLOW_HIDDEN_WIDTH = "overflowHiddenWidth";
        public static final java.lang.String PADDING = "padding";
        public static final java.lang.String PADDING_BOTTOM = "paddingBottom";
        public static final java.lang.String PADDING_LEFT = "paddingLeft";
        public static final java.lang.String PADDING_RIGHT = "paddingRight";
        public static final java.lang.String PADDING_TOP = "paddingTop";
        public static final java.lang.String PAGE_ENABLED = "pagingEnabled";
        public static final java.lang.String PAGE_SIZE = "pageSize";
        public static final java.lang.String PERSPECTIVE = "perspective";
        public static final java.lang.String PLACEHOLDER = "placeholder";
        public static final java.lang.String PLACEHOLDER_COLOR = "placeholderColor";
        public static final java.lang.String PLACE_HOLDER = "placeHolder";
        public static final java.lang.String PLAY_STATUS = "playStatus";
        public static final java.lang.String POSITION = "position";
        public static final java.lang.String PREFIX = "prefix";
        public static final java.lang.String PREVENT_MOVE_EVENT = "preventMoveEvent";
        public static final java.lang.String PRIORITY = "priority";
        public static final java.lang.String PULLING_DISTANCE = "pullingDistance";
        public static final java.lang.String QUALITY = "quality";
        public static final java.lang.String RECYCLE = "recycle";
        public static final java.lang.String RECYCLE_IMAGE = "recycleImage";
        public static final java.lang.String RESIZE = "resize";
        public static final java.lang.String RESIZE_MODE = "resizeMode";
        public static final java.lang.String RETURN_KEY_TYPE = "returnKeyType";
        public static final java.lang.String RIGHT = "right";
        public static final java.lang.String RIGHT_GAP = "rightGap";
        public static final java.lang.String RIPPLE_ENABLED = "rippleEnabled";
        public static final java.lang.String ROLE = "role";
        public static final java.lang.String ROTATE_FIX = "rotateFix";
        public static final java.lang.String ROWS = "rows";
        public static final java.lang.String RTL = "rtl";
        public static final java.lang.String SCOPE = "scope";
        public static final java.lang.String SCROLLABLE = "scrollable";
        public static final java.lang.String SCROLL_DIRECTION = "scrollDirection";
        public static final java.lang.String SCROLL_LEFT = "scrollLeft";
        public static final java.lang.String SCROLL_TOP = "scrollTop";
        public static final java.lang.String SELECTION_END = "selectionEnd";
        public static final java.lang.String SELECTION_START = "selectionStart";
        public static final java.lang.String SHADOW_QUALITY = "shadowQuality";
        public static final java.lang.String SHARPEN = "sharpen";
        public static final java.lang.String SHOULD_STOP_PROPAGATION_INIT_RESULT = "shouldStopPropagationInitResult";
        public static final java.lang.String SHOULD_STOP_PROPAGATION_INTERVAL = "shouldStopPropagationInterval";
        public static final java.lang.String SHOW_INDICATORS = "showIndicators";
        public static final java.lang.String SHOW_LOADING = "show-loading";
        public static final java.lang.String SHOW_SCROLLBAR = "showScrollbar";
        public static final java.lang.String SINGLELINE = "singleline";
        public static final java.lang.String SOURCE = "source";
        public static final java.lang.String SPAN_OFFSETS = "spanOffsets";
        public static final java.lang.String SRC = "src";
        public static final java.lang.String STABLE = "stable";
        public static final java.lang.String STICKY_OFFSET = "stickyOffset";
        public static final java.lang.String STRATEGY = "strategy";
        public static final java.lang.String SUFFIX = "suffix";
        public static final java.lang.String TEXT_ALIGN = "textAlign";
        public static final java.lang.String TEXT_DECORATION = "textDecoration";
        public static final java.lang.String TEXT_OVERFLOW = "textOverflow";
        public static final java.lang.String TOP = "top";
        public static final java.lang.String TRANSFORM = "transform";
        public static final java.lang.String TRANSFORM_ORIGIN = "transformOrigin";
        public static final java.lang.String TYPE = "type";
        public static final java.lang.String UNDEFINED = "undefined";
        public static final java.lang.String VALUE = "value";
        public static final java.lang.String VIEW_HEIGHT = "viewHeight";
        public static final java.lang.String VIF_FALSE = "ifFalse";
        public static final java.lang.String VISIBILITY = "visibility";
        public static final java.lang.String WIDTH = "width";
        public static final java.lang.String X = "x";
        public static final java.lang.String Y = "y";
        public static final java.lang.String ZORDERTOP = "zOrderTop";

        public interface Recycler {
            public static final java.lang.String CELL_INDEX = "cellIndex";
            public static final java.lang.String LIST_DATA = "listData";
            public static final java.lang.String LIST_DATA_ITEM = "alias";
            public static final java.lang.String LIST_DATA_ITEM_INDEX = "index";
            public static final java.lang.String LIST_DATA_TEMPLATE_SWITCH_KEY = "switch";
            public static final java.lang.String SLOT_TEMPLATE_CASE = "case";
            public static final java.lang.String SLOT_TEMPLATE_DEFAULT = "default";
            public static final java.lang.String TYPE_INDEX = "typeIndex";
        }
    }

    public interface Orientation {
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;
    }

    public interface PSEUDO {
        public static final java.lang.String ACTIVE = ":active";
        public static final java.lang.String DISABLED = ":disabled";
        public static final java.lang.String ENABLED = ":enabled";
        public static final java.lang.String FOCUS = ":focus";
    }

    public interface Scheme {
        public static final java.lang.String DATA = "data";
        public static final java.lang.String FILE = "file";
        public static final java.lang.String HTTP = "http";
        public static final java.lang.String HTTPS = "https";
        public static final java.lang.String LOCAL = "local";
    }

    public interface TimeFunction {
        public static final java.lang.String CUBIC_BEZIER = "cubic-bezier";
        public static final java.lang.String EASE = "ease";
        public static final java.lang.String EASE_IN = "ease-in";
        public static final java.lang.String EASE_IN_OUT = "ease-in-out";
        public static final java.lang.String EASE_OUT = "ease-out";
        public static final java.lang.String LINEAR = "linear";
    }

    public interface Value {
        public static final int AUTO = -1;
        public static final java.lang.String BOLD = "bold";
        public static final java.lang.String CENTER = "center";
        public static final int COLUMN_COUNT_NORMAL = 1;
        public static final int COLUMN_GAP_NORMAL = 32;
        public static final java.lang.String DATE = "date";
        public static final java.lang.String DATETIME = "datetime";
        public static final java.lang.String DEFAULT = "default";
        public static final int DENSITY = 3;
        public static final java.lang.String DIRECTION_DOWN = "down";
        public static final java.lang.String DIRECTION_LEFT = "left";
        public static final java.lang.String DIRECTION_RIGHT = "right";
        public static final java.lang.String DIRECTION_UP = "up";
        public static final java.lang.String EMAIL = "email";
        public static final java.lang.String FIXED = "fixed";
        public static final java.lang.String GRID = "grid";
        public static final java.lang.String HIDDEN = "hidden";
        public static final java.lang.String HIGH = "high";
        public static final java.lang.String HORIZONTAL = "horizontal";
        public static final java.lang.String ITALIC = "italic";
        public static final java.lang.String LEFT = "left";
        public static final java.lang.String LOW = "low";
        public static final java.lang.String MULTI_COLUMN = "multi-column";
        public static final int NAV_BAR_HIDDEN = 1;
        public static final int NAV_BAR_SHOWN = 0;
        public static final java.lang.String NONE = "none";
        public static final java.lang.String NORMAL = "normal";
        public static final java.lang.String NUMBER = "number";
        public static final java.lang.String ORIGINAL = "original";
        public static final java.lang.String PASSWORD = "password";
        public static final java.lang.String PAUSE = "pause";
        public static final java.lang.String PLAY = "play";
        public static final java.lang.String RIGHT = "right";
        public static final java.lang.String STICKY = "sticky";
        public static final java.lang.String STOP = "stop";
        public static final java.lang.String TEL = "tel";
        public static final java.lang.String TEXT = "text";
        public static final java.lang.String TIME = "time";
        public static final java.lang.String URL = "url";
        public static final java.lang.String VISIBLE = "visible";
    }

    public interface Weex {
        public static final java.lang.String INSTANCEID = "instanceid";
        public static final java.lang.String REF = "ref";
        public static final java.lang.String TYPE = "type";
    }
}
