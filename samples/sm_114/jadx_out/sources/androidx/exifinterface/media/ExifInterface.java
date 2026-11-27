package androidx.exifinterface.media;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final java.nio.charset.Charset ASCII;
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final java.util.regex.Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final java.util.regex.Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] EXIF_POINTER_TAGS;
    static final androidx.exifinterface.media.ExifInterface.ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final java.lang.String GPS_DIRECTION_MAGNETIC = "M";
    public static final java.lang.String GPS_DIRECTION_TRUE = "T";
    public static final java.lang.String GPS_DISTANCE_KILOMETERS = "K";
    public static final java.lang.String GPS_DISTANCE_MILES = "M";
    public static final java.lang.String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final java.lang.String GPS_MEASUREMENT_2D = "2";
    public static final java.lang.String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final java.lang.String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final java.lang.String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final java.lang.String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final java.lang.String GPS_SPEED_KNOTS = "N";
    public static final java.lang.String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final java.util.regex.Pattern GPS_TIMESTAMP_PATTERN;
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_GPS_TAGS;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    static final int IMAGE_TYPE_ARW = 1;
    static final int IMAGE_TYPE_CR2 = 2;
    static final int IMAGE_TYPE_DNG = 3;
    static final int IMAGE_TYPE_HEIF = 12;
    static final int IMAGE_TYPE_JPEG = 4;
    static final int IMAGE_TYPE_NEF = 5;
    static final int IMAGE_TYPE_NRW = 6;
    static final int IMAGE_TYPE_ORF = 7;
    static final int IMAGE_TYPE_PEF = 8;
    static final int IMAGE_TYPE_PNG = 13;
    static final int IMAGE_TYPE_RAF = 9;
    static final int IMAGE_TYPE_RW2 = 10;
    static final int IMAGE_TYPE_SRW = 11;
    static final int IMAGE_TYPE_UNKNOWN = 0;
    static final int IMAGE_TYPE_WEBP = 14;
    public static final java.lang.String LATITUDE_NORTH = "N";
    public static final java.lang.String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final java.lang.String LONGITUDE_EAST = "E";
    public static final java.lang.String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final java.util.regex.Pattern NON_ZERO_TIME_PATTERN;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final java.lang.String PEF_SIGNATURE = "PENTAX";
    private static final androidx.exifinterface.media.ExifInterface.ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final java.lang.String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final java.lang.String TAG_APERTURE_VALUE = "ApertureValue";
    public static final java.lang.String TAG_ARTIST = "Artist";
    public static final java.lang.String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final java.lang.String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final java.lang.String TAG_BRIGHTNESS_VALUE = "BrightnessValue";

    @java.lang.Deprecated
    public static final java.lang.String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final java.lang.String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final java.lang.String TAG_CFA_PATTERN = "CFAPattern";
    public static final java.lang.String TAG_COLOR_SPACE = "ColorSpace";
    public static final java.lang.String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final java.lang.String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final java.lang.String TAG_COMPRESSION = "Compression";
    public static final java.lang.String TAG_CONTRAST = "Contrast";
    public static final java.lang.String TAG_COPYRIGHT = "Copyright";
    public static final java.lang.String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final java.lang.String TAG_DATETIME = "DateTime";
    public static final java.lang.String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final java.lang.String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final java.lang.String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final java.lang.String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final java.lang.String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final java.lang.String TAG_DNG_VERSION = "DNGVersion";
    private static final java.lang.String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final java.lang.String TAG_EXIF_VERSION = "ExifVersion";
    public static final java.lang.String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final java.lang.String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final java.lang.String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final java.lang.String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final java.lang.String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final java.lang.String TAG_FILE_SOURCE = "FileSource";
    public static final java.lang.String TAG_FLASH = "Flash";
    public static final java.lang.String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final java.lang.String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final java.lang.String TAG_FOCAL_LENGTH = "FocalLength";
    public static final java.lang.String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final java.lang.String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final java.lang.String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final java.lang.String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final java.lang.String TAG_F_NUMBER = "FNumber";
    public static final java.lang.String TAG_GAIN_CONTROL = "GainControl";
    public static final java.lang.String TAG_GAMMA = "Gamma";
    public static final java.lang.String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final java.lang.String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final java.lang.String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final java.lang.String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final java.lang.String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final java.lang.String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final java.lang.String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final java.lang.String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final java.lang.String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final java.lang.String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final java.lang.String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final java.lang.String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final java.lang.String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final java.lang.String TAG_GPS_DOP = "GPSDOP";
    public static final java.lang.String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final java.lang.String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final java.lang.String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final java.lang.String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final java.lang.String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final java.lang.String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final java.lang.String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final java.lang.String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final java.lang.String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final java.lang.String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final java.lang.String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final java.lang.String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final java.lang.String TAG_GPS_SPEED = "GPSSpeed";
    public static final java.lang.String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final java.lang.String TAG_GPS_STATUS = "GPSStatus";
    public static final java.lang.String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final java.lang.String TAG_GPS_TRACK = "GPSTrack";
    public static final java.lang.String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final java.lang.String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final java.lang.String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final java.lang.String TAG_IMAGE_LENGTH = "ImageLength";
    public static final java.lang.String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final java.lang.String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final java.lang.String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final java.lang.String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final java.lang.String TAG_ISO_SPEED = "ISOSpeed";
    public static final java.lang.String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final java.lang.String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @java.lang.Deprecated
    public static final java.lang.String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final java.lang.String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final java.lang.String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final java.lang.String TAG_LENS_MAKE = "LensMake";
    public static final java.lang.String TAG_LENS_MODEL = "LensModel";
    public static final java.lang.String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final java.lang.String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final java.lang.String TAG_LIGHT_SOURCE = "LightSource";
    public static final java.lang.String TAG_MAKE = "Make";
    public static final java.lang.String TAG_MAKER_NOTE = "MakerNote";
    public static final java.lang.String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final java.lang.String TAG_METERING_MODE = "MeteringMode";
    public static final java.lang.String TAG_MODEL = "Model";
    public static final java.lang.String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final java.lang.String TAG_OECF = "OECF";
    public static final java.lang.String TAG_OFFSET_TIME = "OffsetTime";
    public static final java.lang.String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final java.lang.String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final java.lang.String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final java.lang.String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final java.lang.String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final java.lang.String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final java.lang.String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final java.lang.String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final java.lang.String TAG_ORIENTATION = "Orientation";
    public static final java.lang.String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final java.lang.String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final java.lang.String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final java.lang.String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final java.lang.String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final java.lang.String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final androidx.exifinterface.media.ExifInterface.ExifTag TAG_RAF_IMAGE_SIZE;
    public static final java.lang.String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final java.lang.String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final java.lang.String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final java.lang.String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final java.lang.String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final java.lang.String TAG_RW2_ISO = "ISO";
    public static final java.lang.String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final java.lang.String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final java.lang.String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final java.lang.String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final java.lang.String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final java.lang.String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final java.lang.String TAG_SATURATION = "Saturation";
    public static final java.lang.String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final java.lang.String TAG_SCENE_TYPE = "SceneType";
    public static final java.lang.String TAG_SENSING_METHOD = "SensingMethod";
    public static final java.lang.String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final java.lang.String TAG_SHARPNESS = "Sharpness";
    public static final java.lang.String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final java.lang.String TAG_SOFTWARE = "Software";
    public static final java.lang.String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final java.lang.String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final java.lang.String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final java.lang.String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final java.lang.String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final java.lang.String TAG_SUBFILE_TYPE = "SubfileType";
    public static final java.lang.String TAG_SUBJECT_AREA = "SubjectArea";
    public static final java.lang.String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final java.lang.String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final java.lang.String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final java.lang.String TAG_SUBSEC_TIME = "SubSecTime";
    public static final java.lang.String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final java.lang.String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final java.lang.String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final java.lang.String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final java.lang.String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final java.lang.String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final java.lang.String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final java.lang.String TAG_USER_COMMENT = "UserComment";
    public static final java.lang.String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final java.lang.String TAG_WHITE_POINT = "WhitePoint";
    public static final java.lang.String TAG_XMP = "Xmp";
    public static final java.lang.String TAG_X_RESOLUTION = "XResolution";
    public static final java.lang.String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final java.lang.String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final java.lang.String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final java.lang.String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte WEBP_VP8L_SIGNATURE = 47;

    @java.lang.Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @java.lang.Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final java.util.HashMap<java.lang.Integer, java.lang.Integer> sExifPointerTagMap;
    private static final java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface.ExifTag>[] sExifTagMapsForReading;
    private static final java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifTag>[] sExifTagMapsForWriting;
    private static java.text.SimpleDateFormat sFormatterPrimary;
    private static java.text.SimpleDateFormat sFormatterSecondary;
    private static final java.util.HashSet<java.lang.String> sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private android.content.res.AssetManager.AssetInputStream mAssetInputStream;
    private final java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>[] mAttributes;
    private java.util.Set<java.lang.Integer> mAttributesOffsets;
    private java.nio.ByteOrder mExifByteOrder;
    private java.lang.String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private java.io.FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;
    private static final java.lang.String TAG = "ExifInterface";
    private static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);
    private static final java.util.List<java.lang.Integer> ROTATION_ORDER = java.util.Arrays.asList(1, 6, 3, 8);
    private static final java.util.List<java.lang.Integer> FLIPPED_ROTATION_ORDER = java.util.Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    private static final byte MARKER_SOI = -40;
    static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    static final byte START_CODE = 42;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(java.nio.charset.Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(java.nio.charset.Charset.defaultCharset());
    static final java.lang.String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    private static boolean isSupportedFormatForSavingAttributes(int i) {
        return i == 4 || i == 13 || i == 14;
    }

    private static boolean shouldSupportSeek(int i) {
        return (i == 4 || i == 9 || i == 13 || i == 14) ? false : true;
    }

    static {
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr = {new androidx.exifinterface.media.ExifInterface.ExifTag("NewSubfileType", 254, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("SubfileType", 255, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ImageWidth", 256, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ImageLength", 257, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("BitsPerSample", 258, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Compression", 259, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("PhotometricInterpretation", 262, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ImageDescription", 270, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Make", 271, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Model", 272, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("StripOffsets", 273, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("Orientation", com.facebook.imageutils.TiffUtil.TIFF_TAG_ORIENTATION, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("SamplesPerPixel", 277, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("RowsPerStrip", 278, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("StripByteCounts", 279, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("XResolution", 282, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("YResolution", 283, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("PlanarConfiguration", 284, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ResolutionUnit", 296, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("TransferFunction", 301, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Software", 305, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("DateTime", 306, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Artist", 315, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("WhitePoint", 318, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("PrimaryChromaticities", 319, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("JPEGInterchangeFormat", 513, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("JPEGInterchangeFormatLength", 514, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("YCbCrCoefficients", 529, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("YCbCrSubSampling", 530, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("YCbCrPositioning", 531, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ReferenceBlackWhite", 532, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("Copyright", 33432, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("SensorTopBorder", 4, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("SensorLeftBorder", 5, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("SensorBottomBorder", 6, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("SensorRightBorder", 7, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ISO", 23, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("JpgFromRaw", 46, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("Xmp", 700, 1)};
        IFD_TIFF_TAGS = exifTagArr;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr2 = {new androidx.exifinterface.media.ExifInterface.ExifTag("ExposureTime", 33434, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("FNumber", 33437, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("ExposureProgram", 34850, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("SpectralSensitivity", 34852, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("PhotographicSensitivity", 34855, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("OECF", 34856, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("SensitivityType", 34864, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("StandardOutputSensitivity", 34865, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("RecommendedExposureIndex", 34866, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ISOSpeed", 34867, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ISOSpeedLatitudezzz", 34869, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ExifVersion", 36864, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("DateTimeOriginal", 36867, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("DateTimeDigitized", 36868, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("OffsetTime", 36880, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("OffsetTimeOriginal", 36881, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("OffsetTimeDigitized", 36882, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("ComponentsConfiguration", 37121, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("CompressedBitsPerPixel", 37122, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("ShutterSpeedValue", 37377, 10), new androidx.exifinterface.media.ExifInterface.ExifTag("ApertureValue", 37378, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("BrightnessValue", 37379, 10), new androidx.exifinterface.media.ExifInterface.ExifTag("ExposureBiasValue", 37380, 10), new androidx.exifinterface.media.ExifInterface.ExifTag("MaxApertureValue", 37381, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("SubjectDistance", 37382, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("MeteringMode", 37383, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("LightSource", 37384, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Flash", 37385, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("FocalLength", 37386, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("SubjectArea", 37396, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("MakerNote", 37500, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("UserComment", 37510, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("SubSecTime", 37520, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("SubSecTimeOriginal", 37521, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("SubSecTimeDigitized", 37522, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("FlashpixVersion", 40960, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("ColorSpace", 40961, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("PixelXDimension", 40962, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("PixelYDimension", 40963, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("RelatedSoundFile", 40964, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("FlashEnergy", 41483, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("SpatialFrequencyResponse", 41484, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("FocalPlaneXResolution", 41486, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("FocalPlaneYResolution", 41487, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("FocalPlaneResolutionUnit", 41488, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("SubjectLocation", 41492, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ExposureIndex", 41493, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("SensingMethod", 41495, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("FileSource", 41728, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("SceneType", 41729, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("CFAPattern", 41730, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("CustomRendered", 41985, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ExposureMode", 41986, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("WhiteBalance", 41987, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("DigitalZoomRatio", 41988, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("FocalLengthIn35mmFilm", 41989, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("SceneCaptureType", 41990, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("GainControl", 41991, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Contrast", 41992, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Saturation", 41993, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Sharpness", 41994, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("DeviceSettingDescription", 41995, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("SubjectDistanceRange", 41996, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ImageUniqueID", 42016, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("CameraOwnerName", 42032, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("BodySerialNumber", 42033, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("LensSpecification", 42034, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("LensMake", 42035, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("LensModel", 42036, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Gamma", 42240, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("DNGVersion", 50706, 1), new androidx.exifinterface.media.ExifInterface.ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr2;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr3 = {new androidx.exifinterface.media.ExifInterface.ExifTag("GPSVersionID", 0, 1), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSLatitudeRef", 1, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSLatitude", 2, 5, 10), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSLongitudeRef", 3, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSLongitude", 4, 5, 10), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSAltitudeRef", 5, 1), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSAltitude", 6, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSTimeStamp", 7, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSSatellites", 8, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSStatus", 9, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSMeasureMode", 10, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDOP", 11, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSSpeedRef", 12, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSSpeed", 13, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSTrackRef", 14, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSTrack", 15, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSImgDirectionRef", 16, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSImgDirection", 17, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSMapDatum", 18, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestLatitudeRef", 19, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestLatitude", 20, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestLongitudeRef", 21, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestLongitude", 22, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestBearingRef", 23, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestBearing", 24, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestDistanceRef", 25, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDestDistance", 26, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSProcessingMethod", 27, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSAreaInformation", 28, 7), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDateStamp", 29, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSDifferential", 30, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("GPSHPositioningError", 31, 5)};
        IFD_GPS_TAGS = exifTagArr3;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr4 = {new androidx.exifinterface.media.ExifInterface.ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr5 = {new androidx.exifinterface.media.ExifInterface.ExifTag("NewSubfileType", 254, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("SubfileType", 255, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ThumbnailImageWidth", 256, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ThumbnailImageLength", 257, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("BitsPerSample", 258, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Compression", 259, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("PhotometricInterpretation", 262, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ImageDescription", 270, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Make", 271, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Model", 272, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("StripOffsets", 273, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("ThumbnailOrientation", com.facebook.imageutils.TiffUtil.TIFF_TAG_ORIENTATION, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("SamplesPerPixel", 277, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("RowsPerStrip", 278, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("StripByteCounts", 279, 3, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("XResolution", 282, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("YResolution", 283, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("PlanarConfiguration", 284, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ResolutionUnit", 296, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("TransferFunction", 301, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("Software", 305, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("DateTime", 306, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("Artist", 315, 2), new androidx.exifinterface.media.ExifInterface.ExifTag("WhitePoint", 318, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("PrimaryChromaticities", 319, 5), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("JPEGInterchangeFormat", 513, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("JPEGInterchangeFormatLength", 514, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("YCbCrCoefficients", 529, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("YCbCrSubSampling", 530, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("YCbCrPositioning", 531, 3), new androidx.exifinterface.media.ExifInterface.ExifTag("ReferenceBlackWhite", 532, 5), new androidx.exifinterface.media.ExifInterface.ExifTag("Copyright", 33432, 2), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("DNGVersion", 50706, 1), new androidx.exifinterface.media.ExifInterface.ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        TAG_RAF_IMAGE_SIZE = new androidx.exifinterface.media.ExifInterface.ExifTag("StripOffsets", 273, 3);
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr6 = {new androidx.exifinterface.media.ExifInterface.ExifTag("ThumbnailImage", 256, 7), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr7 = {new androidx.exifinterface.media.ExifInterface.ExifTag("PreviewImageStart", 257, 4), new androidx.exifinterface.media.ExifInterface.ExifTag("PreviewImageLength", 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr8 = {new androidx.exifinterface.media.ExifInterface.ExifTag("AspectFrame", 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr9 = {new androidx.exifinterface.media.ExifInterface.ExifTag("ColorSpace", 55, 3)};
        PEF_TAGS = exifTagArr9;
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        EXIF_TAGS = exifTagArr10;
        EXIF_POINTER_TAGS = new androidx.exifinterface.media.ExifInterface.ExifTag[]{new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new androidx.exifinterface.media.ExifInterface.ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        sExifTagMapsForReading = new java.util.HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new java.util.HashMap[exifTagArr10.length];
        sTagSetForCompatibility = new java.util.HashSet<>(java.util.Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        sExifPointerTagMap = new java.util.HashMap<>();
        java.nio.charset.Charset charsetForName = java.nio.charset.Charset.forName("US-ASCII");
        ASCII = charsetForName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(charsetForName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy:MM:dd HH:mm:ss", java.util.Locale.US);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        java.text.SimpleDateFormat simpleDateFormat2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr11 = EXIF_TAGS;
            if (i < exifTagArr11.length) {
                sExifTagMapsForReading[i] = new java.util.HashMap<>();
                sExifTagMapsForWriting[i] = new java.util.HashMap<>();
                for (androidx.exifinterface.media.ExifInterface.ExifTag exifTag : exifTagArr11[i]) {
                    sExifTagMapsForReading[i].put(java.lang.Integer.valueOf(exifTag.number), exifTag);
                    sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
                }
                i++;
            } else {
                java.util.HashMap<java.lang.Integer, java.lang.Integer> map = sExifPointerTagMap;
                androidx.exifinterface.media.ExifInterface.ExifTag[] exifTagArr12 = EXIF_POINTER_TAGS;
                map.put(java.lang.Integer.valueOf(exifTagArr12[0].number), 5);
                map.put(java.lang.Integer.valueOf(exifTagArr12[1].number), 1);
                map.put(java.lang.Integer.valueOf(exifTagArr12[2].number), 2);
                map.put(java.lang.Integer.valueOf(exifTagArr12[3].number), 3);
                map.put(java.lang.Integer.valueOf(exifTagArr12[4].number), 7);
                map.put(java.lang.Integer.valueOf(exifTagArr12[5].number), 8);
                NON_ZERO_TIME_PATTERN = java.util.regex.Pattern.compile(".*[1-9].*");
                GPS_TIMESTAMP_PATTERN = java.util.regex.Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_PRIMARY_FORMAT_PATTERN = java.util.regex.Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_SECONDARY_FORMAT_PATTERN = java.util.regex.Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    private static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d) {
            this((long) (d * 10000.0d), 10000L);
        }

        Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j;
                this.denominator = j2;
            }
        }

        public java.lang.String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }
    }

    private static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        ExifAttribute(int i, int i2, long j, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort(int[] iArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(3, iArr.length, byteBufferWrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createUShort(int i, java.nio.ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createULong(long[] jArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(4, jArr.length, byteBufferWrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createULong(long j, java.nio.ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSLong(int[] iArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putInt(i);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(9, iArr.length, byteBufferWrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSLong(int i, java.nio.ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createByte(java.lang.String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new androidx.exifinterface.media.ExifInterface.ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(androidx.exifinterface.media.ExifInterface.ASCII);
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(1, bytes.length, bytes);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createString(java.lang.String str) {
            byte[] bytes = (str + (char) 0).getBytes(androidx.exifinterface.media.ExifInterface.ASCII);
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(2, bytes.length, bytes);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createURational(androidx.exifinterface.media.ExifInterface.Rational[] rationalArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            byteBufferWrap.order(byteOrder);
            for (androidx.exifinterface.media.ExifInterface.Rational rational : rationalArr) {
                byteBufferWrap.putInt((int) rational.numerator);
                byteBufferWrap.putInt((int) rational.denominator);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(5, rationalArr.length, byteBufferWrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createURational(androidx.exifinterface.media.ExifInterface.Rational rational, java.nio.ByteOrder byteOrder) {
            return createURational(new androidx.exifinterface.media.ExifInterface.Rational[]{rational}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSRational(androidx.exifinterface.media.ExifInterface.Rational[] rationalArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length]);
            byteBufferWrap.order(byteOrder);
            for (androidx.exifinterface.media.ExifInterface.Rational rational : rationalArr) {
                byteBufferWrap.putInt((int) rational.numerator);
                byteBufferWrap.putInt((int) rational.denominator);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(10, rationalArr.length, byteBufferWrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createSRational(androidx.exifinterface.media.ExifInterface.Rational rational, java.nio.ByteOrder byteOrder) {
            return createSRational(new androidx.exifinterface.media.ExifInterface.Rational[]{rational}, byteOrder);
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createDouble(double[] dArr, java.nio.ByteOrder byteOrder) {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(new byte[androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d : dArr) {
                byteBufferWrap.putDouble(d);
            }
            return new androidx.exifinterface.media.ExifInterface.ExifAttribute(12, dArr.length, byteBufferWrap.array());
        }

        public static androidx.exifinterface.media.ExifInterface.ExifAttribute createDouble(double d, java.nio.ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public java.lang.String toString() {
            return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + androidx.exifinterface.media.ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
        }

        /* JADX WARN: Code duplicated, block: B:105:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0149: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:94:0x0149 */
        java.lang.Object getValue(java.nio.ByteOrder byteOrder) throws java.lang.Throwable {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream;
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2;
            byte b;
            byte b2;
            java.lang.Object str;
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream3 = null;
            try {
                try {
                    byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(this.bytes);
                    try {
                        byteOrderedDataInputStream.setByteOrder(byteOrder);
                        int length = 0;
                        switch (this.format) {
                            case 1:
                            case 6:
                                byte[] bArr = this.bytes;
                                str = (bArr.length == 1 && (b = bArr[0]) >= 0 && b <= 1) ? new java.lang.String(new char[]{(char) (this.bytes[0] + 48)}) : new java.lang.String(this.bytes, androidx.exifinterface.media.ExifInterface.ASCII);
                                break;
                            case 2:
                            case 7:
                                if (this.numberOfComponents >= androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX.length) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX.length) {
                                            length = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX.length;
                                        } else if (this.bytes[i] == androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX[i]) {
                                            i++;
                                        }
                                    }
                                }
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                while (length < this.numberOfComponents && (b2 = this.bytes[length]) != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF);
                                    }
                                    length++;
                                }
                                str = sb.toString();
                                break;
                            case 3:
                                int[] iArr = new int[this.numberOfComponents];
                                while (true) {
                                    str = iArr;
                                    if (length < this.numberOfComponents) {
                                        iArr[length] = byteOrderedDataInputStream.readUnsignedShort();
                                        length++;
                                    }
                                }
                                break;
                            case 4:
                                long[] jArr = new long[this.numberOfComponents];
                                while (true) {
                                    str = jArr;
                                    if (length < this.numberOfComponents) {
                                        jArr[length] = byteOrderedDataInputStream.readUnsignedInt();
                                        length++;
                                    }
                                }
                                break;
                            case 5:
                                androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = new androidx.exifinterface.media.ExifInterface.Rational[this.numberOfComponents];
                                while (true) {
                                    str = rationalArr;
                                    if (length < this.numberOfComponents) {
                                        rationalArr[length] = new androidx.exifinterface.media.ExifInterface.Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                        length++;
                                    }
                                }
                                break;
                            case 8:
                                int[] iArr2 = new int[this.numberOfComponents];
                                while (true) {
                                    str = iArr2;
                                    if (length < this.numberOfComponents) {
                                        iArr2[length] = byteOrderedDataInputStream.readShort();
                                        length++;
                                    }
                                }
                                break;
                            case 9:
                                int[] iArr3 = new int[this.numberOfComponents];
                                while (true) {
                                    str = iArr3;
                                    if (length < this.numberOfComponents) {
                                        iArr3[length] = byteOrderedDataInputStream.readInt();
                                        length++;
                                    }
                                }
                                break;
                            case 10:
                                androidx.exifinterface.media.ExifInterface.Rational[] rationalArr2 = new androidx.exifinterface.media.ExifInterface.Rational[this.numberOfComponents];
                                while (true) {
                                    str = rationalArr2;
                                    if (length < this.numberOfComponents) {
                                        rationalArr2[length] = new androidx.exifinterface.media.ExifInterface.Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                        length++;
                                    }
                                }
                                break;
                            case 11:
                                double[] dArr = new double[this.numberOfComponents];
                                while (true) {
                                    str = dArr;
                                    if (length < this.numberOfComponents) {
                                        dArr[length] = byteOrderedDataInputStream.readFloat();
                                        length++;
                                    }
                                }
                                break;
                            case 12:
                                double[] dArr2 = new double[this.numberOfComponents];
                                while (true) {
                                    str = dArr2;
                                    if (length < this.numberOfComponents) {
                                        dArr2[length] = byteOrderedDataInputStream.readDouble();
                                        length++;
                                    }
                                }
                                break;
                            default:
                                try {
                                    byteOrderedDataInputStream.close();
                                    return null;
                                } catch (java.io.IOException e) {
                                    android.util.Log.e(androidx.exifinterface.media.ExifInterface.TAG, "IOException occurred while closing InputStream", e);
                                    return null;
                                }
                        }
                        try {
                            byteOrderedDataInputStream.close();
                            return str;
                        } catch (java.io.IOException e2) {
                            android.util.Log.e(androidx.exifinterface.media.ExifInterface.TAG, "IOException occurred while closing InputStream", e2);
                            return str;
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        android.util.Log.w(androidx.exifinterface.media.ExifInterface.TAG, "IOException occurred during reading a value", e);
                        if (byteOrderedDataInputStream != null) {
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (java.io.IOException e4) {
                                android.util.Log.e(androidx.exifinterface.media.ExifInterface.TAG, "IOException occurred while closing InputStream", e4);
                            }
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteOrderedDataInputStream3 = byteOrderedDataInputStream2;
                    if (byteOrderedDataInputStream3 != null) {
                        try {
                            byteOrderedDataInputStream3.close();
                        } catch (java.io.IOException e5) {
                            android.util.Log.e(androidx.exifinterface.media.ExifInterface.TAG, "IOException occurred while closing InputStream", e5);
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e6) {
                e = e6;
                byteOrderedDataInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (byteOrderedDataInputStream3 != null) {
                    byteOrderedDataInputStream3.close();
                }
                throw th;
            }
        }

        public double getDoubleValue(java.nio.ByteOrder byteOrder) throws java.lang.Throwable {
            java.lang.Object value = getValue(byteOrder);
            if (value == null) {
                throw new java.lang.NumberFormatException("NULL can't be converted to a double value");
            }
            if (value instanceof java.lang.String) {
                return java.lang.Double.parseDouble((java.lang.String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return jArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (value instanceof androidx.exifinterface.media.ExifInterface.Rational[]) {
                androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) value;
                if (rationalArr.length == 1) {
                    return rationalArr[0].calculate();
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            throw new java.lang.NumberFormatException("Couldn't find a double value");
        }

        public int getIntValue(java.nio.ByteOrder byteOrder) throws java.lang.Throwable {
            java.lang.Object value = getValue(byteOrder);
            if (value == null) {
                throw new java.lang.NumberFormatException("NULL can't be converted to a integer value");
            }
            if (value instanceof java.lang.String) {
                return java.lang.Integer.parseInt((java.lang.String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new java.lang.NumberFormatException("There are more than one component");
            }
            throw new java.lang.NumberFormatException("Couldn't find a integer value");
        }

        public java.lang.String getStringValue(java.nio.ByteOrder byteOrder) throws java.lang.Throwable {
            java.lang.Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof java.lang.String) {
                return (java.lang.String) value;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(value instanceof androidx.exifinterface.media.ExifInterface.Rational[])) {
                return null;
            }
            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) value;
            while (i < rationalArr.length) {
                sb.append(rationalArr[i].numerator);
                sb.append('/');
                sb.append(rationalArr[i].denominator);
                i++;
                if (i != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public int size() {
            return androidx.exifinterface.media.ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }
    }

    static class ExifTag {
        public final java.lang.String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(java.lang.String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        ExifTag(java.lang.String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }

        boolean isFormatCompatible(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }
    }

    public ExifInterface(java.io.File file) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (file == null) {
            throw new java.lang.NullPointerException("file cannot be null");
        }
        initForFilename(file.getAbsolutePath());
    }

    public ExifInterface(java.lang.String str) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new java.lang.NullPointerException("filename cannot be null");
        }
        initForFilename(str);
    }

    public ExifInterface(java.io.FileDescriptor fileDescriptor) throws java.lang.Throwable {
        boolean z;
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (fileDescriptor == null) {
            throw new java.lang.NullPointerException("fileDescriptor cannot be null");
        }
        this.mAssetInputStream = null;
        this.mFilename = null;
        if (isSeekableFD(fileDescriptor)) {
            this.mSeekableFileDescriptor = fileDescriptor;
            try {
                fileDescriptor = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.dup(fileDescriptor);
                z = true;
            } catch (java.lang.Exception e) {
                throw new java.io.IOException("Failed to duplicate file descriptor", e);
            }
        } else {
            this.mSeekableFileDescriptor = null;
            z = false;
        }
        try {
            fileInputStream = new java.io.FileInputStream(fileDescriptor);
            try {
                loadAttributes(fileInputStream);
                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream);
                if (z) {
                    androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream);
                if (z) {
                    androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public ExifInterface(java.io.InputStream inputStream) throws java.io.IOException {
        this(inputStream, 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0065  */
    public ExifInterface(java.io.InputStream inputStream, int i) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new java.util.HashMap[exifTagArr.length];
        this.mAttributesOffsets = new java.util.HashSet(exifTagArr.length);
        this.mExifByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new java.lang.NullPointerException("inputStream cannot be null");
        }
        this.mFilename = null;
        if (i == 1) {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, IDENTIFIER_EXIF_APP1.length);
            if (!isExifDataOnly(bufferedInputStream)) {
                android.util.Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.mIsExifDataOnly = true;
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof android.content.res.AssetManager.AssetInputStream) {
            this.mAssetInputStream = (android.content.res.AssetManager.AssetInputStream) inputStream;
            this.mSeekableFileDescriptor = null;
        } else if (inputStream instanceof java.io.FileInputStream) {
            java.io.FileInputStream fileInputStream = (java.io.FileInputStream) inputStream;
            if (isSeekableFD(fileInputStream.getFD())) {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = fileInputStream.getFD();
            } else {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
        } else {
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
        }
        loadAttributes(inputStream);
    }

    public static boolean isSupportedMimeType(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("mimeType shouldn't be null");
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ROOT);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "image/x-fuji-raf":
            case "image/x-samsung-srw":
            case "image/x-sony-arw":
            case "image/heic":
            case "image/heif":
            case "image/jpeg":
            case "image/webp":
            case "image/x-adobe-dng":
            case "image/x-panasonic-rw2":
            case "image/png":
            case "image/x-pentax-pef":
            case "image/x-olympus-orf":
            case "image/x-nikon-nef":
            case "image/x-nikon-nrw":
            case "image/x-canon-cr2":
                return true;
            default:
                return false;
        }
    }

    private androidx.exifinterface.media.ExifInterface.ExifAttribute getExifAttribute(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (DEBUG) {
                android.util.Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    public java.lang.String getAttribute(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals("GPSTimeStamp")) {
                if (exifAttribute.format != 5 && exifAttribute.format != 10) {
                    android.util.Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                    return null;
                }
                androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 3) {
                    android.util.Log.w(TAG, "Invalid GPS Timestamp array. array=" + java.util.Arrays.toString(rationalArr));
                    return null;
                }
                return java.lang.String.format("%02d:%02d:%02d", java.lang.Integer.valueOf((int) (rationalArr[0].numerator / rationalArr[0].denominator)), java.lang.Integer.valueOf((int) (rationalArr[1].numerator / rationalArr[1].denominator)), java.lang.Integer.valueOf((int) (rationalArr[2].numerator / rationalArr[2].denominator)));
            }
            try {
                return java.lang.Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return null;
    }

    public int getAttributeInt(java.lang.String str, int i) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return i;
    }

    public double getAttributeDouble(java.lang.String str, double d) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            try {
                return exifAttribute.getDoubleValue(this.mExifByteOrder);
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return d;
    }

    public void setAttribute(java.lang.String str, java.lang.String str2) {
        androidx.exifinterface.media.ExifInterface.ExifTag exifTag;
        int i;
        java.lang.String str3 = str;
        java.lang.String strReplaceAll = str2;
        if (str3 == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
            boolean zFind = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(strReplaceAll).find();
            boolean zFind2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(strReplaceAll).find();
            if (strReplaceAll.length() != 19 || (!zFind && !zFind2)) {
                android.util.Log.w(TAG, "Invalid value for " + str3 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll(com.taobao.weex.el.parse.Operators.SUB, ":");
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            if (DEBUG) {
                android.util.Log.d(TAG, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = "PhotographicSensitivity";
        }
        int i2 = 2;
        int i3 = 1;
        if (strReplaceAll != null && sTagSetForCompatibility.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                java.util.regex.Matcher matcher = GPS_TIMESTAMP_PATTERN.matcher(strReplaceAll);
                if (!matcher.find()) {
                    android.util.Log.w(TAG, "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = java.lang.Integer.parseInt(matcher.group(1)) + "/1," + java.lang.Integer.parseInt(matcher.group(2)) + "/1," + java.lang.Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new androidx.exifinterface.media.ExifInterface.Rational(java.lang.Double.parseDouble(strReplaceAll)).toString();
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.w(TAG, "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        char c = 0;
        int i4 = 0;
        while (i4 < EXIF_TAGS.length) {
            if ((i4 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i4].get(str3)) != null) {
                if (strReplaceAll == null) {
                    this.mAttributes[i4].remove(str3);
                } else {
                    android.util.Pair<java.lang.Integer, java.lang.Integer> pairGuessDataFormat = guessDataFormat(strReplaceAll);
                    if (exifTag.primaryFormat == ((java.lang.Integer) pairGuessDataFormat.first).intValue() || exifTag.primaryFormat == ((java.lang.Integer) pairGuessDataFormat.second).intValue()) {
                        i = exifTag.primaryFormat;
                    } else if (exifTag.secondaryFormat != -1 && (exifTag.secondaryFormat == ((java.lang.Integer) pairGuessDataFormat.first).intValue() || exifTag.secondaryFormat == ((java.lang.Integer) pairGuessDataFormat.second).intValue())) {
                        i = exifTag.secondaryFormat;
                    } else if (exifTag.primaryFormat == i3 || exifTag.primaryFormat == 7 || exifTag.primaryFormat == i2) {
                        i = exifTag.primaryFormat;
                    } else if (DEBUG) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("Given tag (");
                        sb.append(str3);
                        sb.append(") value didn't match with one of expected formats: ");
                        java.lang.String[] strArr = IFD_FORMAT_NAMES;
                        sb.append(strArr[exifTag.primaryFormat]);
                        sb.append(exifTag.secondaryFormat == -1 ? "" : ", " + strArr[exifTag.secondaryFormat]);
                        sb.append(" (guess: ");
                        sb.append(strArr[((java.lang.Integer) pairGuessDataFormat.first).intValue()]);
                        sb.append(((java.lang.Integer) pairGuessDataFormat.second).intValue() != -1 ? ", " + strArr[((java.lang.Integer) pairGuessDataFormat.second).intValue()] : "");
                        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                        android.util.Log.d(TAG, sb.toString());
                    }
                    switch (i) {
                        case 1:
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createByte(strReplaceAll));
                            continue;
                        case 2:
                        case 7:
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(strReplaceAll));
                            continue;
                        case 3:
                            java.lang.String[] strArrSplit = strReplaceAll.split(",", -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i5 = 0; i5 < strArrSplit.length; i5++) {
                                iArr[i5] = java.lang.Integer.parseInt(strArrSplit[i5]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                            continue;
                        case 4:
                            java.lang.String[] strArrSplit2 = strReplaceAll.split(",", -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i6 = 0; i6 < strArrSplit2.length; i6++) {
                                jArr[i6] = java.lang.Long.parseLong(strArrSplit2[i6]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(jArr, this.mExifByteOrder));
                            continue;
                        case 5:
                            java.lang.String[] strArrSplit3 = strReplaceAll.split(",", -1);
                            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = new androidx.exifinterface.media.ExifInterface.Rational[strArrSplit3.length];
                            int i7 = 0;
                            while (i7 < strArrSplit3.length) {
                                java.lang.String[] strArrSplit4 = strArrSplit3[i7].split("/", -1);
                                int i8 = i7;
                                rationalArr[i8] = new androidx.exifinterface.media.ExifInterface.Rational((long) java.lang.Double.parseDouble(strArrSplit4[0]), (long) java.lang.Double.parseDouble(strArrSplit4[1]));
                                i7 = i8 + 1;
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                            continue;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (DEBUG) {
                                android.util.Log.d(TAG, "Data format isn't one of expected formats: " + i);
                            } else {
                                continue;
                            }
                            break;
                        case 9:
                            java.lang.String[] strArrSplit5 = strReplaceAll.split(",", -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i9 = 0; i9 < strArrSplit5.length; i9++) {
                                iArr2[i9] = java.lang.Integer.parseInt(strArrSplit5[i9]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                            continue;
                        case 10:
                            java.lang.String[] strArrSplit6 = strReplaceAll.split(",", -1);
                            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr2 = new androidx.exifinterface.media.ExifInterface.Rational[strArrSplit6.length];
                            int i10 = 0;
                            while (i10 < strArrSplit6.length) {
                                java.lang.String[] strArrSplit7 = strArrSplit6[i10].split("/", -1);
                                rationalArr2[i10] = new androidx.exifinterface.media.ExifInterface.Rational((long) java.lang.Double.parseDouble(strArrSplit7[c]), (long) java.lang.Double.parseDouble(strArrSplit7[i3]));
                                i10++;
                                strArrSplit6 = strArrSplit6;
                                c = 0;
                                i3 = 1;
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                            continue;
                        case 12:
                            java.lang.String[] strArrSplit8 = strReplaceAll.split(",", -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i11 = 0; i11 < strArrSplit8.length; i11++) {
                                dArr[i11] = java.lang.Double.parseDouble(strArrSplit8[i11]);
                            }
                            this.mAttributes[i4].put(str3, androidx.exifinterface.media.ExifInterface.ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                            break;
                    }
                }
            }
            i4++;
            i2 = 2;
            c = 0;
            i3 = 1;
        }
    }

    public void resetOrientation() {
        setAttribute("Orientation", java.lang.Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 != 0) {
            throw new java.lang.IllegalArgumentException("degree should be a multiple of 90");
        }
        int attributeInt = getAttributeInt("Orientation", 1);
        java.util.List<java.lang.Integer> list = ROTATION_ORDER;
        int iIntValue = 0;
        if (list.contains(java.lang.Integer.valueOf(attributeInt))) {
            int iIndexOf = (list.indexOf(java.lang.Integer.valueOf(attributeInt)) + (i / 90)) % 4;
            iIntValue = list.get(iIndexOf + (iIndexOf < 0 ? 4 : 0)).intValue();
        } else {
            java.util.List<java.lang.Integer> list2 = FLIPPED_ROTATION_ORDER;
            if (list2.contains(java.lang.Integer.valueOf(attributeInt))) {
                int iIndexOf2 = (list2.indexOf(java.lang.Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                iIntValue = list2.get(iIndexOf2 + (iIndexOf2 < 0 ? 4 : 0)).intValue();
            }
        }
        setAttribute("Orientation", java.lang.Integer.toString(iIntValue));
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute("Orientation", java.lang.Integer.toString(i));
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute("Orientation", java.lang.Integer.toString(i));
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt("Orientation", 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    private void removeAttribute(java.lang.String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void loadAttributes(java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.NullPointerException("inputstream shouldn't be null");
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                try {
                    this.mAttributes[i] = new java.util.HashMap<>();
                } catch (java.lang.Throwable th) {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                    throw th;
                }
            } catch (java.io.IOException | java.lang.UnsupportedOperationException e) {
                boolean z = DEBUG;
                if (z) {
                    android.util.Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                addDefaultValuesForCompatibility();
                if (z) {
                    printAttributes();
                    return;
                }
                return;
            }
        }
        if (!this.mIsExifDataOnly) {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 5000);
            this.mMimeType = getMimeType(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (shouldSupportSeek(this.mMimeType)) {
            androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream(inputStream);
            if (this.mIsExifDataOnly) {
                getStandaloneAttributes(seekableByteOrderedDataInputStream);
            } else {
                int i2 = this.mMimeType;
                if (i2 == 12) {
                    getHeifAttributes(seekableByteOrderedDataInputStream);
                } else if (i2 == 7) {
                    getOrfAttributes(seekableByteOrderedDataInputStream);
                } else if (i2 == 10) {
                    getRw2Attributes(seekableByteOrderedDataInputStream);
                } else {
                    getRawAttributes(seekableByteOrderedDataInputStream);
                }
            }
            seekableByteOrderedDataInputStream.seek(this.mOffsetToExifData);
            setThumbnailData(seekableByteOrderedDataInputStream);
        } else {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(inputStream);
            int i3 = this.mMimeType;
            if (i3 == 4) {
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
            } else if (i3 == 13) {
                getPngAttributes(byteOrderedDataInputStream);
            } else if (i3 == 9) {
                getRafAttributes(byteOrderedDataInputStream);
            } else if (i3 == 14) {
                getWebpAttributes(byteOrderedDataInputStream);
            }
        }
        addDefaultValuesForCompatibility();
        if (DEBUG) {
            printAttributes();
        }
    }

    private static boolean isSeekableFD(java.io.FileDescriptor fileDescriptor) {
        try {
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(fileDescriptor, 0L, android.system.OsConstants.SEEK_CUR);
            return true;
        } catch (java.lang.Exception unused) {
            if (!DEBUG) {
                return false;
            }
            android.util.Log.d(TAG, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private void printAttributes() {
        for (int i = 0; i < this.mAttributes.length; i++) {
            android.util.Log.d(TAG, "The size of tag group[" + i + "]: " + this.mAttributes[i].size());
            for (java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> entry : this.mAttributes[i].entrySet()) {
                androidx.exifinterface.media.ExifInterface.ExifAttribute value = entry.getValue();
                android.util.Log.d(TAG, "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00e9 A[Catch: all -> 0x0111, Exception -> 0x0114, TryCatch #19 {Exception -> 0x0114, all -> 0x0111, blocks: (B:64:0x00e5, B:66:0x00e9, B:68:0x00ff, B:67:0x00f8), top: B:130:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f8 A[Catch: all -> 0x0111, Exception -> 0x0114, TryCatch #19 {Exception -> 0x0114, all -> 0x0111, blocks: (B:64:0x00e5, B:66:0x00e9, B:68:0x00ff, B:67:0x00f8), top: B:130:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0146  */
    public void saveAttributes() throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileInputStream fileInputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Exception exc;
        java.io.OutputStream fileOutputStream2;
        java.io.InputStream fileInputStream2;
        java.lang.Exception e;
        java.io.FileOutputStream fileOutputStream3;
        if (!isSupportedFormatForSavingAttributes(this.mMimeType)) {
            throw new java.io.IOException("ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats.");
        }
        if (this.mSeekableFileDescriptor == null && this.mFilename == null) {
            throw new java.io.IOException("ExifInterface does not support saving attributes for the current input.");
        }
        if (this.mHasThumbnail && this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
            throw new java.io.IOException("ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips");
        }
        boolean z = true;
        this.mModified = true;
        this.mThumbnailBytes = getThumbnail();
        java.io.InputStream inputStream = null;
        try {
            java.io.File fileCreateTempFile = java.io.File.createTempFile("temp", "tmp");
            if (this.mFilename != null) {
                fileInputStream = new java.io.FileInputStream(this.mFilename);
            } else {
                androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, android.system.OsConstants.SEEK_SET);
                fileInputStream = new java.io.FileInputStream(this.mSeekableFileDescriptor);
            }
            try {
                fileOutputStream = new java.io.FileOutputStream(fileCreateTempFile);
                try {
                    androidx.exifinterface.media.ExifInterfaceUtils.copy(fileInputStream, fileOutputStream);
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream);
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream);
                    boolean z2 = false;
                    try {
                        try {
                            try {
                                java.io.FileInputStream fileInputStream3 = new java.io.FileInputStream(fileCreateTempFile);
                                try {
                                    if (this.mFilename != null) {
                                        fileOutputStream2 = new java.io.FileOutputStream(this.mFilename);
                                    } else {
                                        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, android.system.OsConstants.SEEK_SET);
                                        fileOutputStream2 = new java.io.FileOutputStream(this.mSeekableFileDescriptor);
                                    }
                                    try {
                                        bufferedInputStream = new java.io.BufferedInputStream(fileInputStream3);
                                        try {
                                            bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream2);
                                            try {
                                                int i = this.mMimeType;
                                                if (i == 4) {
                                                    saveJpegAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 13) {
                                                    savePngAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 14) {
                                                    saveWebpAttributes(bufferedInputStream, bufferedOutputStream);
                                                }
                                                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(bufferedInputStream);
                                                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(bufferedOutputStream);
                                                fileCreateTempFile.delete();
                                                this.mThumbnailBytes = null;
                                            } catch (java.lang.Exception e2) {
                                                exc = e2;
                                                inputStream = fileInputStream3;
                                                try {
                                                    fileInputStream2 = new java.io.FileInputStream(fileCreateTempFile);
                                                    try {
                                                        if (this.mFilename == null) {
                                                            fileOutputStream3 = new java.io.FileOutputStream(this.mFilename);
                                                        } else {
                                                            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, android.system.OsConstants.SEEK_SET);
                                                            fileOutputStream3 = new java.io.FileOutputStream(this.mSeekableFileDescriptor);
                                                        }
                                                        fileOutputStream2 = fileOutputStream3;
                                                        androidx.exifinterface.media.ExifInterfaceUtils.copy(fileInputStream2, fileOutputStream2);
                                                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream2);
                                                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream2);
                                                        throw new java.io.IOException("Failed to save new file", exc);
                                                    } catch (java.lang.Exception e3) {
                                                        e = e3;
                                                        try {
                                                            throw new java.io.IOException("Failed to save new file. Original file is stored in " + fileCreateTempFile.getAbsolutePath(), e);
                                                        } catch (java.lang.Throwable th) {
                                                            th = th;
                                                            inputStream = fileInputStream2;
                                                            try {
                                                                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                                                                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream2);
                                                                throw th;
                                                            } catch (java.lang.Throwable th2) {
                                                                th = th2;
                                                                z2 = z;
                                                                inputStream = bufferedInputStream;
                                                                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                                                                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(bufferedOutputStream);
                                                                if (!z2) {
                                                                    fileCreateTempFile.delete();
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (java.lang.Throwable th3) {
                                                        th = th3;
                                                        inputStream = fileInputStream2;
                                                        z = false;
                                                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                                                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream2);
                                                        throw th;
                                                    }
                                                } catch (java.lang.Exception e4) {
                                                    fileInputStream2 = inputStream;
                                                    e = e4;
                                                } catch (java.lang.Throwable th4) {
                                                    th = th4;
                                                }
                                            }
                                        } catch (java.lang.Exception e5) {
                                            bufferedOutputStream = null;
                                            inputStream = fileInputStream3;
                                            exc = e5;
                                        } catch (java.lang.Throwable th5) {
                                            th = th5;
                                            bufferedOutputStream = null;
                                            inputStream = bufferedInputStream;
                                            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                                            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(bufferedOutputStream);
                                            if (!z2) {
                                                fileCreateTempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (java.lang.Exception e6) {
                                        bufferedOutputStream = null;
                                        inputStream = fileInputStream3;
                                        exc = e6;
                                        bufferedInputStream = null;
                                    }
                                } catch (java.lang.Exception e7) {
                                    e = e7;
                                    bufferedInputStream = null;
                                    bufferedOutputStream = null;
                                    inputStream = fileInputStream3;
                                    exc = e;
                                    fileOutputStream2 = bufferedOutputStream;
                                    fileInputStream2 = new java.io.FileInputStream(fileCreateTempFile);
                                    if (this.mFilename == null) {
                                        fileOutputStream3 = new java.io.FileOutputStream(this.mFilename);
                                    } else {
                                        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(this.mSeekableFileDescriptor, 0L, android.system.OsConstants.SEEK_SET);
                                        fileOutputStream3 = new java.io.FileOutputStream(this.mSeekableFileDescriptor);
                                    }
                                    fileOutputStream2 = fileOutputStream3;
                                    androidx.exifinterface.media.ExifInterfaceUtils.copy(fileInputStream2, fileOutputStream2);
                                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream2);
                                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream2);
                                    throw new java.io.IOException("Failed to save new file", exc);
                                }
                            } catch (java.lang.Exception e8) {
                                e = e8;
                                bufferedInputStream = null;
                                bufferedOutputStream = null;
                            }
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            bufferedOutputStream = null;
                            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(bufferedOutputStream);
                            if (!z2) {
                                fileCreateTempFile.delete();
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                    }
                } catch (java.lang.Exception e9) {
                    e = e9;
                    inputStream = fileInputStream;
                    try {
                        throw new java.io.IOException("Failed to copy original file to temp file", e);
                    } catch (java.lang.Throwable th8) {
                        th = th8;
                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th9) {
                    th = th9;
                    inputStream = fileInputStream;
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(inputStream);
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception e10) {
                e = e10;
                fileOutputStream = null;
            } catch (java.lang.Throwable th10) {
                th = th10;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception e11) {
            e = e11;
            fileOutputStream = null;
        } catch (java.lang.Throwable th11) {
            th = th11;
            fileOutputStream = null;
        }
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean hasAttribute(java.lang.String str) {
        return getExifAttribute(str) != null;
    }

    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public byte[] getThumbnailBytes() throws java.lang.Throwable {
        java.io.FileDescriptor fileDescriptor;
        ?? r1;
        java.lang.Exception e;
        java.io.FileDescriptor fileDescriptor2;
        ?? fileInputStream;
        ?? fileInputStream2;
        ?? r2 = 0;
        r2 = 0;
        if (!this.mHasThumbnail) {
            return null;
        }
        ?? r3 = this.mThumbnailBytes;
        try {
            if (r3 != 0) {
                return r3;
            }
            try {
                r3 = this.mAssetInputStream;
                if (r3 != 0) {
                    try {
                        if (!r3.markSupported()) {
                            android.util.Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");
                            androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r3);
                            return null;
                        }
                        r3.reset();
                        fileInputStream2 = r3;
                        fileDescriptor2 = null;
                        fileInputStream = fileInputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileDescriptor2 = null;
                        r1 = r3;
                        android.util.Log.d(TAG, "Encountered exception while getting thumbnail", e);
                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1);
                        if (fileDescriptor2 != null) {
                            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                        }
                        return null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileDescriptor = null;
                        r2 = r3;
                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2);
                        if (fileDescriptor != null) {
                            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                } else if (this.mFilename != null) {
                    fileInputStream2 = new java.io.FileInputStream(this.mFilename);
                    fileDescriptor2 = null;
                    fileInputStream = fileInputStream2;
                } else {
                    java.io.FileDescriptor fileDescriptorDup = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.dup(this.mSeekableFileDescriptor);
                    try {
                        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.lseek(fileDescriptorDup, 0L, android.system.OsConstants.SEEK_SET);
                        fileDescriptor2 = fileDescriptorDup;
                        fileInputStream = new java.io.FileInputStream(fileDescriptorDup);
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileDescriptor2 = fileDescriptorDup;
                        r1 = 0;
                        android.util.Log.d(TAG, "Encountered exception while getting thumbnail", e);
                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1);
                        if (fileDescriptor2 != null) {
                            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                        }
                        return null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileDescriptor = fileDescriptorDup;
                        androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r2);
                        if (fileDescriptor != null) {
                            androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                }
                try {
                    if (fileInputStream == 0) {
                        throw new java.io.FileNotFoundException();
                    }
                    if (fileInputStream.skip(this.mThumbnailOffset + this.mOffsetToExifData) != this.mThumbnailOffset + this.mOffsetToExifData) {
                        throw new java.io.IOException("Corrupted image");
                    }
                    byte[] bArr = new byte[this.mThumbnailLength];
                    if (fileInputStream.read(bArr) != this.mThumbnailLength) {
                        throw new java.io.IOException("Corrupted image");
                    }
                    this.mThumbnailBytes = bArr;
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream);
                    if (fileDescriptor2 != null) {
                        androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                    }
                    return bArr;
                } catch (java.lang.Exception e4) {
                    e = e4;
                    r1 = fileInputStream;
                    android.util.Log.d(TAG, "Encountered exception while getting thumbnail", e);
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(r1);
                    if (fileDescriptor2 != null) {
                        androidx.exifinterface.media.ExifInterfaceUtils.closeFileDescriptor(fileDescriptor2);
                    }
                    return null;
                }
            } catch (java.lang.Exception e5) {
                r1 = 0;
                e = e5;
                fileDescriptor2 = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileDescriptor = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    public android.graphics.Bitmap getThumbnailBitmap() throws java.lang.Throwable {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return android.graphics.BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[4].get("ThumbnailImageLength");
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[4].get("ThumbnailImageWidth");
            if (exifAttribute != null && exifAttribute2 != null) {
                return android.graphics.Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), android.graphics.Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i = this.mThumbnailCompression;
        return i == 6 || i == 7;
    }

    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new java.lang.IllegalStateException("The underlying file has been modified since being parsed");
        }
        if (!this.mHasThumbnail) {
            return null;
        }
        if (!this.mHasThumbnailStrips || this.mAreThumbnailStripsConsecutive) {
            return new long[]{this.mThumbnailOffset + this.mOffsetToExifData, this.mThumbnailLength};
        }
        return null;
    }

    public long[] getAttributeRange(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        if (this.mModified) {
            throw new java.lang.IllegalStateException("The underlying file has been modified since being parsed");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            return new long[]{exifAttribute.bytesOffset, exifAttribute.bytes.length};
        }
        return null;
    }

    public byte[] getAttributeBytes(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag shouldn't be null");
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            return exifAttribute.bytes;
        }
        return null;
    }

    @java.lang.Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public double[] getLatLong() {
        java.lang.String attribute = getAttribute("GPSLatitude");
        java.lang.String attribute2 = getAttribute("GPSLatitudeRef");
        java.lang.String attribute3 = getAttribute("GPSLongitude");
        java.lang.String attribute4 = getAttribute("GPSLongitudeRef");
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (java.lang.IllegalArgumentException unused) {
            android.util.Log.w(TAG, "Latitude/longitude values are not parsable. " + java.lang.String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            return null;
        }
    }

    public void setGpsInfo(android.location.Location location) {
        if (location == null) {
            return;
        }
        setAttribute("GPSProcessingMethod", location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute("GPSSpeedRef", "K");
        setAttribute("GPSSpeed", new androidx.exifinterface.media.ExifInterface.Rational((location.getSpeed() * java.util.concurrent.TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        java.lang.String[] strArrSplit = sFormatterPrimary.format(new java.util.Date(location.getTime())).split("\\s+", -1);
        setAttribute("GPSDateStamp", strArrSplit[0]);
        setAttribute("GPSTimeStamp", strArrSplit[1]);
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || java.lang.Double.isNaN(d)) {
            throw new java.lang.IllegalArgumentException("Latitude value " + d + " is not valid.");
        }
        if (d2 < -180.0d || d2 > 180.0d || java.lang.Double.isNaN(d2)) {
            throw new java.lang.IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        }
        setAttribute("GPSLatitudeRef", d >= 0.0d ? "N" : "S");
        setAttribute("GPSLatitude", convertDecimalDegree(java.lang.Math.abs(d)));
        setAttribute("GPSLongitudeRef", d2 >= 0.0d ? "E" : "W");
        setAttribute("GPSLongitude", convertDecimalDegree(java.lang.Math.abs(d2)));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble("GPSAltitude", -1.0d);
        int attributeInt = getAttributeInt("GPSAltitudeRef", -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        return attributeDouble * ((double) (attributeInt != 1 ? 1 : -1));
    }

    public void setAltitude(double d) {
        java.lang.String str = d >= 0.0d ? com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT : "1";
        setAttribute("GPSAltitude", new androidx.exifinterface.media.ExifInterface.Rational(java.lang.Math.abs(d)).toString());
        setAttribute("GPSAltitudeRef", str);
    }

    public void setDateTime(java.lang.Long l) {
        if (l == null) {
            throw new java.lang.NullPointerException("Timestamp should not be null.");
        }
        if (l.longValue() < 0) {
            throw new java.lang.IllegalArgumentException("Timestamp should a positive value.");
        }
        java.lang.String string = java.lang.Long.toString(l.longValue() % 1000);
        for (int length = string.length(); length < 3; length++) {
            string = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + string;
        }
        setAttribute("DateTime", sFormatterPrimary.format(new java.util.Date(l.longValue())));
        setAttribute("SubSecTime", string);
    }

    public java.lang.Long getDateTime() {
        return parseDateTime(getAttribute("DateTime"), getAttribute("SubSecTime"), getAttribute("OffsetTime"));
    }

    public java.lang.Long getDateTimeDigitized() {
        return parseDateTime(getAttribute("DateTimeDigitized"), getAttribute("SubSecTimeDigitized"), getAttribute("OffsetTimeDigitized"));
    }

    public java.lang.Long getDateTimeOriginal() {
        return parseDateTime(getAttribute("DateTimeOriginal"), getAttribute("SubSecTimeOriginal"), getAttribute("OffsetTimeOriginal"));
    }

    private static java.lang.Long parseDateTime(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str != null && NON_ZERO_TIME_PATTERN.matcher(str).matches()) {
            java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
            try {
                java.util.Date date = sFormatterPrimary.parse(str, parsePosition);
                if (date == null && (date = sFormatterSecondary.parse(str, parsePosition)) == null) {
                    return null;
                }
                long time = date.getTime();
                if (str3 != null) {
                    int i = 1;
                    java.lang.String strSubstring = str3.substring(0, 1);
                    int i2 = java.lang.Integer.parseInt(str3.substring(1, 3));
                    int i3 = java.lang.Integer.parseInt(str3.substring(4, 6));
                    if ((com.taobao.weex.el.parse.Operators.PLUS.equals(strSubstring) || com.taobao.weex.el.parse.Operators.SUB.equals(strSubstring)) && ":".equals(str3.substring(3, 4)) && i2 <= 14) {
                        int i4 = ((i2 * 60) + i3) * com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS;
                        if (!com.taobao.weex.el.parse.Operators.SUB.equals(strSubstring)) {
                            i = -1;
                        }
                        time += (long) (i4 * i);
                    }
                }
                if (str2 != null) {
                    time += androidx.exifinterface.media.ExifInterfaceUtils.parseSubSeconds(str2);
                }
                return java.lang.Long.valueOf(time);
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public java.lang.Long getGpsDateTime() {
        java.lang.String attribute = getAttribute("GPSDateStamp");
        java.lang.String attribute2 = getAttribute("GPSTimeStamp");
        if (attribute != null && attribute2 != null) {
            java.util.regex.Pattern pattern = NON_ZERO_TIME_PATTERN;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                java.lang.String str = attribute + ' ' + attribute2;
                java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
                try {
                    java.util.Date date = sFormatterPrimary.parse(str, parsePosition);
                    if (date == null && (date = sFormatterSecondary.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return java.lang.Long.valueOf(date.getTime());
                } catch (java.lang.IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    private void initForFilename(java.lang.String str) throws java.lang.Throwable {
        if (str == null) {
            throw new java.lang.NullPointerException("filename cannot be null");
        }
        java.io.FileInputStream fileInputStream = null;
        this.mAssetInputStream = null;
        this.mFilename = str;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(str);
            try {
                if (isSeekableFD(fileInputStream2.getFD())) {
                    this.mSeekableFileDescriptor = fileInputStream2.getFD();
                } else {
                    this.mSeekableFileDescriptor = null;
                }
                loadAttributes(fileInputStream2);
                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static double convertRationalLatLonToDouble(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String[] strArrSplit = str.split(",", -1);
            java.lang.String[] strArrSplit2 = strArrSplit[0].split("/", -1);
            double d = java.lang.Double.parseDouble(strArrSplit2[0].trim()) / java.lang.Double.parseDouble(strArrSplit2[1].trim());
            java.lang.String[] strArrSplit3 = strArrSplit[1].split("/", -1);
            double d2 = java.lang.Double.parseDouble(strArrSplit3[0].trim()) / java.lang.Double.parseDouble(strArrSplit3[1].trim());
            java.lang.String[] strArrSplit4 = strArrSplit[2].split("/", -1);
            double d3 = d + (d2 / 60.0d) + ((java.lang.Double.parseDouble(strArrSplit4[0].trim()) / java.lang.Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d);
            if (!str2.equals("S") && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals("E")) {
                    throw new java.lang.IllegalArgumentException();
                }
                return d3;
            }
            return -d3;
        } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.NumberFormatException unused) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    private java.lang.String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - j;
        long j2 = (long) (d2 * 60.0d);
        return j + "/1," + j2 + "/1," + java.lang.Math.round((d2 - (j2 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    private int getMimeType(java.io.BufferedInputStream bufferedInputStream) throws java.io.IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private static boolean isJpegFormat(byte[] bArr) throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws java.io.IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(java.nio.charset.Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isHeifFormat(byte[] bArr) throws java.lang.Throwable {
        long j;
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            try {
                androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
                try {
                    long length = byteOrderedDataInputStream2.readInt();
                    byte[] bArr2 = new byte[4];
                    byteOrderedDataInputStream2.read(bArr2);
                    if (!java.util.Arrays.equals(bArr2, HEIF_TYPE_FTYP)) {
                        byteOrderedDataInputStream2.close();
                        return false;
                    }
                    if (length == 1) {
                        length = byteOrderedDataInputStream2.readLong();
                        j = 16;
                        if (length < 16) {
                            byteOrderedDataInputStream2.close();
                            return false;
                        }
                    } else {
                        j = 8;
                    }
                    if (length > bArr.length) {
                        length = bArr.length;
                    }
                    long j2 = length - j;
                    if (j2 < 8) {
                        byteOrderedDataInputStream2.close();
                        return false;
                    }
                    byte[] bArr3 = new byte[4];
                    boolean z = false;
                    boolean z2 = false;
                    for (long j3 = 0; j3 < j2 / 4; j3++) {
                        if (byteOrderedDataInputStream2.read(bArr3) != 4) {
                            byteOrderedDataInputStream2.close();
                            return false;
                        }
                        if (j3 != 1) {
                            if (java.util.Arrays.equals(bArr3, HEIF_BRAND_MIF1)) {
                                z = true;
                            } else if (java.util.Arrays.equals(bArr3, HEIF_BRAND_HEIC)) {
                                z2 = true;
                            }
                            if (z && z2) {
                                byteOrderedDataInputStream2.close();
                                return true;
                            }
                        }
                    }
                    byteOrderedDataInputStream2.close();
                } catch (java.lang.Exception e) {
                    e = e;
                    byteOrderedDataInputStream = byteOrderedDataInputStream2;
                    if (DEBUG) {
                        android.util.Log.d(TAG, "Exception parsing HEIF file type box.", e);
                    }
                    if (byteOrderedDataInputStream != null) {
                        byteOrderedDataInputStream.close();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteOrderedDataInputStream = byteOrderedDataInputStream2;
                    if (byteOrderedDataInputStream != null) {
                        byteOrderedDataInputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
            try {
                java.nio.ByteOrder byteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = byteOrder;
                byteOrderedDataInputStream2.setByteOrder(byteOrder);
                short s = byteOrderedDataInputStream2.readShort();
                boolean z = s == 20306 || s == 21330;
                byteOrderedDataInputStream2.close();
                return z;
            } catch (java.lang.Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private boolean isRw2Format(byte[] bArr) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr);
            try {
                java.nio.ByteOrder byteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = byteOrder;
                byteOrderedDataInputStream2.setByteOrder(byteOrder);
                boolean z = byteOrderedDataInputStream2.readShort() == 85;
                byteOrderedDataInputStream2.close();
                return z;
            } catch (java.lang.Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private boolean isPngFormat(byte[] bArr) throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isWebpFormat(byte[] bArr) throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    private static boolean isExifDataOnly(java.io.BufferedInputStream bufferedInputStream) throws java.io.IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ae A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:63:0x0170 A[LOOP:0: B:10:0x0034->B:63:0x0170, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:81:0x0177 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private void getRawAttributes(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute;
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType != 8 || (exifAttribute = this.mAttributes[1].get("MakerNote")) == null) {
            return;
        }
        androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream(exifAttribute.bytes);
        seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
        seekableByteOrderedDataInputStream2.skipFully(6);
        readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[9].get("ColorSpace");
        if (exifAttribute2 != null) {
            this.mAttributes[1].put("ColorSpace", exifAttribute2);
        }
    }

    private void getRafAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.lang.Throwable {
        boolean z = DEBUG;
        if (z) {
            android.util.Log.d(TAG, "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.skipFully(RAF_OFFSET_TO_JPEG_IMAGE_OFFSET);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i = java.nio.ByteBuffer.wrap(bArr).getInt();
        int i2 = java.nio.ByteBuffer.wrap(bArr2).getInt();
        int i3 = java.nio.ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        byteOrderedDataInputStream.skipFully(i - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr4), i, 5);
        byteOrderedDataInputStream.skipFully(i3 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        int i4 = byteOrderedDataInputStream.readInt();
        if (z) {
            android.util.Log.d(TAG, "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (unsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short s = byteOrderedDataInputStream.readShort();
                short s2 = byteOrderedDataInputStream.readShort();
                androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(s, this.mExifByteOrder);
                androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(s2, this.mExifByteOrder);
                this.mAttributes[0].put("ImageLength", exifAttributeCreateUShort);
                this.mAttributes[0].put("ImageWidth", exifAttributeCreateUShort2);
                if (DEBUG) {
                    android.util.Log.d(TAG, "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipFully(unsignedShort2);
        }
    }

    private void getHeifAttributes(final androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws java.io.IOException {
        java.lang.String strExtractMetadata;
        java.lang.String strExtractMetadata2;
        java.lang.String strExtractMetadata3;
        int i;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            throw new java.lang.UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            try {
                androidx.exifinterface.media.ExifInterfaceUtils.Api23Impl.setDataSource(mediaMetadataRetriever, new android.media.MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1
                    long mPosition;

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws java.io.IOException {
                    }

                    @Override // android.media.MediaDataSource
                    public long getSize() throws java.io.IOException {
                        return -1L;
                    }

                    @Override // android.media.MediaDataSource
                    public int readAt(long j, byte[] bArr, int i2, int i3) throws java.io.IOException {
                        if (i3 == 0) {
                            return 0;
                        }
                        if (j < 0) {
                            return -1;
                        }
                        try {
                            long j2 = this.mPosition;
                            if (j2 != j) {
                                if (j2 >= 0 && j >= j2 + ((long) seekableByteOrderedDataInputStream.available())) {
                                    return -1;
                                }
                                seekableByteOrderedDataInputStream.seek(j);
                                this.mPosition = j;
                            }
                            if (i3 > seekableByteOrderedDataInputStream.available()) {
                                i3 = seekableByteOrderedDataInputStream.available();
                            }
                            int i4 = seekableByteOrderedDataInputStream.read(bArr, i2, i3);
                            if (i4 >= 0) {
                                this.mPosition += (long) i4;
                                return i4;
                            }
                        } catch (java.io.IOException unused) {
                        }
                        this.mPosition = -1L;
                        return -1;
                    }
                });
                java.lang.String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                java.lang.String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                java.lang.String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                java.lang.String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.mAttributes[0].put("ImageWidth", androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(java.lang.Integer.parseInt(strExtractMetadata), this.mExifByteOrder));
                }
                if (strExtractMetadata2 != null) {
                    this.mAttributes[0].put("ImageLength", androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(java.lang.Integer.parseInt(strExtractMetadata2), this.mExifByteOrder));
                }
                if (strExtractMetadata3 != null) {
                    int i2 = java.lang.Integer.parseInt(strExtractMetadata3);
                    if (i2 == 90) {
                        i = 6;
                    } else if (i2 != 180) {
                        i = i2 != 270 ? 1 : 8;
                    } else {
                        i = 3;
                    }
                    this.mAttributes[0].put("Orientation", androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(i, this.mExifByteOrder));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i3 = java.lang.Integer.parseInt(strExtractMetadata4);
                    int i4 = java.lang.Integer.parseInt(strExtractMetadata5);
                    if (i4 <= 6) {
                        throw new java.io.IOException("Invalid exif length");
                    }
                    seekableByteOrderedDataInputStream.seek(i3);
                    byte[] bArr = new byte[6];
                    if (seekableByteOrderedDataInputStream.read(bArr) != 6) {
                        throw new java.io.IOException("Can't read identifier");
                    }
                    int i5 = i3 + 6;
                    int i6 = i4 - 6;
                    if (!java.util.Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                        throw new java.io.IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    if (seekableByteOrderedDataInputStream.read(bArr2) != i6) {
                        throw new java.io.IOException("Can't read exif");
                    }
                    this.mOffsetToExifData = i5;
                    readExifSegment(bArr2, 0);
                }
                if (DEBUG) {
                    android.util.Log.d(TAG, "Heif meta: " + strExtractMetadata + com.taobao.weex.common.Constants.Name.X + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (java.lang.RuntimeException unused) {
                throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (java.lang.Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    private void getStandaloneAttributes(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws java.io.IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        seekableByteOrderedDataInputStream.skipFully(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getOrfAttributes(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws java.lang.Throwable {
        int i;
        int i2;
        getRawAttributes(seekableByteOrderedDataInputStream);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[1].get("MakerNote");
        if (exifAttribute != null) {
            androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (java.util.Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.seek(8L);
            } else if (java.util.Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[7].get("PreviewImageStart");
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.mAttributes[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.mAttributes[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    android.util.Log.w(TAG, "Invalid aspect frame values. frame=" + java.util.Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(i5, this.mExifByteOrder);
                androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(i6, this.mExifByteOrder);
                this.mAttributes[0].put("ImageWidth", exifAttributeCreateUShort);
                this.mAttributes[0].put("ImageLength", exifAttributeCreateUShort2);
            }
        }
    }

    private void getRw2Attributes(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws java.lang.Throwable {
        if (DEBUG) {
            android.util.Log.d(TAG, "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            getJpegAttributes(new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[0].get("ISO");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[1].get("PhotographicSensitivity");
        if (exifAttribute2 == null || exifAttribute3 != null) {
            return;
        }
        this.mAttributes[1].put("PhotographicSensitivity", exifAttribute2);
    }

    private void getPngAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.lang.Throwable {
        if (DEBUG) {
            android.util.Log.d(TAG, "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = length + 8;
                if (i2 == 16 && !java.util.Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                    throw new java.io.IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (java.util.Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                    return;
                }
                if (java.util.Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                    byte[] bArr3 = new byte[i];
                    if (byteOrderedDataInputStream.read(bArr3) != i) {
                        throw new java.io.IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.ExifInterfaceUtils.byteArrayToHexString(bArr2));
                    }
                    int i3 = byteOrderedDataInputStream.readInt();
                    java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) != i3) {
                        throw new java.io.IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                    }
                    this.mOffsetToExifData = i2;
                    readExifSegment(bArr3, 0);
                    validateImages();
                    setThumbnailData(new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr3));
                    return;
                }
                int i4 = i + 4;
                byteOrderedDataInputStream.skipFully(i4);
                length = i2 + i4;
            } catch (java.io.EOFException unused) {
                throw new java.io.IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getWebpAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.lang.Throwable {
        if (DEBUG) {
            android.util.Log.d(TAG, "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(java.nio.ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int i = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) != 4) {
                    throw new java.io.IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i2 = byteOrderedDataInputStream.readInt();
                int i3 = length + 8;
                if (java.util.Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    if (byteOrderedDataInputStream.read(bArr3) != i2) {
                        throw new java.io.IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.ExifInterfaceUtils.byteArrayToHexString(bArr2));
                    }
                    this.mOffsetToExifData = i3;
                    readExifSegment(bArr3, 0);
                    setThumbnailData(new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr3));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new java.io.IOException("Encountered WebP file with invalid chunk size");
                }
                byteOrderedDataInputStream.skipFully(i2);
            } catch (java.io.EOFException unused) {
                throw new java.io.IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void saveJpegAttributes(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        if (DEBUG) {
            android.util.Log.d(TAG, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(inputStream);
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(outputStream, java.nio.ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() != -1) {
            throw new java.io.IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-1);
        if (byteOrderedDataInputStream.readByte() != -40) {
            throw new java.io.IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-40);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeRemove = (getAttribute("Xmp") == null || !this.mXmpIsFromSeparateMarker) ? null : this.mAttributes[0].remove("Xmp");
        byteOrderedDataOutputStream.writeByte(-1);
        byteOrderedDataOutputStream.writeByte(-31);
        writeExifSegment(byteOrderedDataOutputStream);
        if (exifAttributeRemove != null) {
            this.mAttributes[0].put("Xmp", exifAttributeRemove);
        }
        byte[] bArr = new byte[4096];
        while (byteOrderedDataInputStream.readByte() == -1) {
            byte b = byteOrderedDataInputStream.readByte();
            if (b == -39 || b == -38) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(b);
                androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                return;
            }
            if (b == -31) {
                int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                int i = unsignedShort - 2;
                if (i < 0) {
                    throw new java.io.IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (i >= 6) {
                    if (byteOrderedDataInputStream.read(bArr2) != 6) {
                        throw new java.io.IOException("Invalid exif");
                    }
                    if (java.util.Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                        byteOrderedDataInputStream.skipFully(unsignedShort - 8);
                    }
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(b);
                byteOrderedDataOutputStream.writeUnsignedShort(unsignedShort);
                if (i >= 6) {
                    i = unsignedShort - 8;
                    byteOrderedDataOutputStream.write(bArr2);
                }
                while (i > 0) {
                    int i2 = byteOrderedDataInputStream.read(bArr, 0, java.lang.Math.min(i, 4096));
                    if (i2 < 0) {
                        break;
                    }
                    byteOrderedDataOutputStream.write(bArr, 0, i2);
                    i -= i2;
                }
            } else {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(b);
                int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                byteOrderedDataOutputStream.writeUnsignedShort(unsignedShort2);
                int i3 = unsignedShort2 - 2;
                if (i3 < 0) {
                    throw new java.io.IOException("Invalid length");
                }
                while (i3 > 0) {
                    int i4 = byteOrderedDataInputStream.read(bArr, 0, java.lang.Math.min(i3, 4096));
                    if (i4 < 0) {
                        break;
                    }
                    byteOrderedDataOutputStream.write(bArr, 0, i4);
                    i3 -= i4;
                }
            }
        }
        throw new java.io.IOException("Invalid marker");
    }

    private void savePngAttributes(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.lang.Throwable {
        if (DEBUG) {
            android.util.Log.d(TAG, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(inputStream);
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(outputStream, java.nio.ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i = this.mOffsetToExifData;
        if (i == 0) {
            int i2 = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(i2);
            androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, i2 + 8);
        } else {
            androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, (i - bArr.length) - 8);
            byteOrderedDataInputStream.skipFully(byteOrderedDataInputStream.readInt() + 8);
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            try {
                androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(byteArrayOutputStream2, java.nio.ByteOrder.BIG_ENDIAN);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((java.io.ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
                androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void saveWebpAttributes(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.lang.Throwable {
        char c;
        int i;
        int i2;
        int i3;
        if (DEBUG) {
            android.util.Log.d(TAG, "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(inputStream, java.nio.ByteOrder.LITTLE_ENDIAN);
        androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(outputStream, java.nio.ByteOrder.LITTLE_ENDIAN);
        byte[] bArr = WEBP_SIGNATURE_1;
        androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr2.length + 4);
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                try {
                    androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream(byteArrayOutputStream2, java.nio.ByteOrder.LITTLE_ENDIAN);
                    int i4 = this.mOffsetToExifData;
                    if (i4 != 0) {
                        androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, (i4 - ((bArr.length + 4) + bArr2.length)) - 8);
                        byteOrderedDataInputStream.skipFully(4);
                        int i5 = byteOrderedDataInputStream.readInt();
                        if (i5 % 2 != 0) {
                            i5++;
                        }
                        byteOrderedDataInputStream.skipFully(i5);
                        writeExifSegment(byteOrderedDataOutputStream2);
                    } else {
                        byte[] bArr3 = new byte[4];
                        if (byteOrderedDataInputStream.read(bArr3) != 4) {
                            throw new java.io.IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                        byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                        boolean z = true;
                        if (java.util.Arrays.equals(bArr3, bArr4)) {
                            int i6 = byteOrderedDataInputStream.readInt();
                            byte[] bArr5 = new byte[i6 % 2 == 1 ? i6 + 1 : i6];
                            byteOrderedDataInputStream.read(bArr5);
                            byte b = (byte) (8 | bArr5[0]);
                            bArr5[0] = b;
                            boolean z2 = ((b >> 1) & 1) == 1;
                            byteOrderedDataOutputStream2.write(bArr4);
                            byteOrderedDataOutputStream2.writeInt(i6);
                            byteOrderedDataOutputStream2.write(bArr5);
                            if (z2) {
                                copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream.read(bArr6);
                                    if (!java.util.Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF)) {
                                        break;
                                    } else {
                                        copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                                    }
                                }
                                writeExifSegment(byteOrderedDataOutputStream2);
                            } else {
                                copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                                writeExifSegment(byteOrderedDataOutputStream2);
                            }
                        } else {
                            byte[] bArr7 = WEBP_CHUNK_TYPE_VP8;
                            if (java.util.Arrays.equals(bArr3, bArr7) || java.util.Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                int i7 = byteOrderedDataInputStream.readInt();
                                int i8 = i7 % 2 == 1 ? i7 + 1 : i7;
                                byte[] bArr8 = new byte[3];
                                if (java.util.Arrays.equals(bArr3, bArr7)) {
                                    byteOrderedDataInputStream.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    c = '\b';
                                    if (byteOrderedDataInputStream.read(bArr9) != 3 || !java.util.Arrays.equals(WEBP_VP8_SIGNATURE, bArr9)) {
                                        throw new java.io.IOException("Encountered error while checking VP8 signature");
                                    }
                                    i = byteOrderedDataInputStream.readInt();
                                    i8 -= 10;
                                    i3 = (i << 2) >> 18;
                                    i2 = (i << 18) >> 18;
                                    z = false;
                                } else {
                                    c = '\b';
                                    if (!java.util.Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                        i = 0;
                                        z = false;
                                        i2 = 0;
                                        i3 = 0;
                                    } else {
                                        if (byteOrderedDataInputStream.readByte() != 47) {
                                            throw new java.io.IOException("Encountered error while checking VP8L signature");
                                        }
                                        i = byteOrderedDataInputStream.readInt();
                                        i2 = (i & 16383) + 1;
                                        i3 = ((i & 268419072) >>> 14) + 1;
                                        if ((i & 268435456) == 0) {
                                            z = false;
                                        }
                                        i8 -= 5;
                                    }
                                }
                                byteOrderedDataOutputStream2.write(bArr4);
                                byteOrderedDataOutputStream2.writeInt(10);
                                byte[] bArr10 = new byte[10];
                                if (z) {
                                    bArr10[0] = (byte) (bArr10[0] | 16);
                                }
                                bArr10[0] = (byte) (bArr10[0] | 8);
                                int i9 = i2 - 1;
                                int i10 = i3 - 1;
                                bArr10[4] = (byte) i9;
                                bArr10[5] = (byte) (i9 >> 8);
                                bArr10[6] = (byte) (i9 >> 16);
                                bArr10[7] = (byte) i10;
                                bArr10[c] = (byte) (i10 >> 8);
                                bArr10[9] = (byte) (i10 >> 16);
                                byteOrderedDataOutputStream2.write(bArr10);
                                byteOrderedDataOutputStream2.write(bArr3);
                                byteOrderedDataOutputStream2.writeInt(i7);
                                if (java.util.Arrays.equals(bArr3, bArr7)) {
                                    byteOrderedDataOutputStream2.write(bArr8);
                                    byteOrderedDataOutputStream2.write(WEBP_VP8_SIGNATURE);
                                    byteOrderedDataOutputStream2.writeInt(i);
                                } else if (java.util.Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    byteOrderedDataOutputStream2.write(47);
                                    byteOrderedDataOutputStream2.writeInt(i);
                                }
                                androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i8);
                                writeExifSegment(byteOrderedDataOutputStream2);
                            }
                        }
                    }
                    androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                    int size = byteArrayOutputStream2.size();
                    byte[] bArr11 = WEBP_SIGNATURE_2;
                    byteOrderedDataOutputStream.writeInt(size + bArr11.length);
                    byteOrderedDataOutputStream.write(bArr11);
                    byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(byteArrayOutputStream2);
                } catch (java.lang.Exception e) {
                    e = e;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new java.io.IOException("Failed to save WebP file", e);
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    androidx.exifinterface.media.ExifInterfaceUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void copyChunksUpToGivenChunkType(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws java.io.IOException {
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ");
                java.nio.charset.Charset charset = ASCII;
                sb.append(new java.lang.String(bArr, charset));
                sb.append(bArr2 == null ? "" : " or ".concat(new java.lang.String(bArr2, charset)));
                throw new java.io.IOException(sb.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (java.util.Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && java.util.Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws java.io.IOException {
        int i = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(i);
        if (i % 2 == 1) {
            i++;
        }
        androidx.exifinterface.media.ExifInterfaceUtils.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, i);
    }

    private void readExifSegment(byte[] bArr, int i) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i);
    }

    private void addDefaultValuesForCompatibility() {
        java.lang.String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null && getAttribute("DateTime") == null) {
            this.mAttributes[0].put("DateTime", androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.mAttributes[0].put("ImageWidth", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            this.mAttributes[0].put("ImageLength", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            this.mAttributes[0].put("Orientation", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            this.mAttributes[1].put("LightSource", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    private java.nio.ByteOrder readByteOrder(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        short s = byteOrderedDataInputStream.readShort();
        if (s == 18761) {
            if (DEBUG) {
                android.util.Log.d(TAG, "readExifSegment: Byte Align II");
            }
            return java.nio.ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (DEBUG) {
                android.util.Log.d(TAG, "readExifSegment: Byte Align MM");
            }
            return java.nio.ByteOrder.BIG_ENDIAN;
        }
        throw new java.io.IOException("Invalid byte order: " + java.lang.Integer.toHexString(s));
    }

    private void parseTiffHeaders(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.io.IOException {
        java.nio.ByteOrder byteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = byteOrder;
        byteOrderedDataInputStream.setByteOrder(byteOrder);
        int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i = this.mMimeType;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            throw new java.io.IOException("Invalid start code: " + java.lang.Integer.toHexString(unsignedShort));
        }
        int i2 = byteOrderedDataInputStream.readInt();
        if (i2 < 8) {
            throw new java.io.IOException("Invalid first Ifd offset: " + i2);
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            byteOrderedDataInputStream.skipFully(i3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:104:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:106:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:115:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:142:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0126  */
    /* JADX WARN: Code duplicated, block: B:48:0x0131  */
    /* JADX WARN: Code duplicated, block: B:50:0x0139  */
    /* JADX WARN: Code duplicated, block: B:52:0x0143  */
    /* JADX WARN: Code duplicated, block: B:53:0x0157  */
    /* JADX WARN: Code duplicated, block: B:56:0x015e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0168  */
    /* JADX WARN: Code duplicated, block: B:59:0x016b  */
    /* JADX WARN: Code duplicated, block: B:61:0x016e  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:79:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:83:0x0209  */
    /* JADX WARN: Code duplicated, block: B:84:0x020e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0213  */
    /* JADX WARN: Code duplicated, block: B:88:0x021a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0234  */
    /* JADX WARN: Code duplicated, block: B:93:0x0241  */
    /* JADX WARN: Code duplicated, block: B:94:0x024c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x024e  */
    /* JADX WARN: Code duplicated, block: B:96:0x026d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x026f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0285  */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x0143, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:69:0x01d4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:95:0x024e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:97:0x026f, please report this as an issue */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws java.io.IOException {
        char c;
        long j;
        long j2;
        boolean z;
        long j3;
        java.lang.Integer num;
        int unsignedShort;
        long unsignedInt;
        int i2;
        this.mAttributesOffsets.add(java.lang.Integer.valueOf(seekableByteOrderedDataInputStream.mPosition));
        short s = seekableByteOrderedDataInputStream.readShort();
        if (DEBUG) {
            android.util.Log.d(TAG, "numberOfDirectoryEntry: " + ((int) s));
        }
        if (s <= 0) {
            return;
        }
        short s2 = 0;
        while (s2 < s) {
            int unsignedShort2 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort3 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int i3 = seekableByteOrderedDataInputStream.readInt();
            long jPosition = ((long) seekableByteOrderedDataInputStream.position()) + 4;
            androidx.exifinterface.media.ExifInterface.ExifTag exifTag = sExifTagMapsForReading[i].get(java.lang.Integer.valueOf(unsignedShort2));
            boolean z2 = DEBUG;
            if (z2) {
                c = 4;
                android.util.Log.d(TAG, java.lang.String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(unsignedShort2), exifTag != null ? exifTag.name : null, java.lang.Integer.valueOf(unsignedShort3), java.lang.Integer.valueOf(i3)));
            } else {
                c = 4;
            }
            if (exifTag != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                    if (unsignedShort3 < iArr.length) {
                        if (exifTag.isFormatCompatible(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = exifTag.primaryFormat;
                            }
                            j = jPosition;
                            j2 = ((long) i3) * ((long) iArr[unsignedShort3]);
                            if (j2 < 0 || j2 > 2147483647L) {
                                if (z2) {
                                    android.util.Log.d(TAG, "Skip the tag entry since the number of components is invalid: " + i3);
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                        } else if (z2) {
                            android.util.Log.d(TAG, "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[unsignedShort3] + ") is unexpected for tag: " + exifTag.name);
                        }
                    }
                    if (!z) {
                        seekableByteOrderedDataInputStream.seek(j);
                        s = s;
                        s2 = s2;
                    } else {
                        j3 = j;
                        if (j2 > 4) {
                            i2 = seekableByteOrderedDataInputStream.readInt();
                            if (z2) {
                                android.util.Log.d(TAG, "seek to data offset: " + i2);
                            }
                            if (this.mMimeType == 7) {
                                if ("MakerNote".equals(exifTag.name)) {
                                    this.mOrfMakerNoteOffset = i2;
                                } else if (i != 6 && "ThumbnailImage".equals(exifTag.name)) {
                                    this.mOrfThumbnailOffset = i2;
                                    this.mOrfThumbnailLength = i3;
                                    androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(6, this.mExifByteOrder);
                                    androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateULong = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                    androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateULong2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                    this.mAttributes[c].put("Compression", exifAttributeCreateUShort);
                                    this.mAttributes[c].put("JPEGInterchangeFormat", exifAttributeCreateULong);
                                    this.mAttributes[c].put("JPEGInterchangeFormatLength", exifAttributeCreateULong2);
                                }
                            }
                            seekableByteOrderedDataInputStream.seek(i2);
                        } else {
                            unsignedShort2 = unsignedShort2;
                            i3 = i3;
                            z2 = z2;
                        }
                        num = sExifPointerTagMap.get(java.lang.Integer.valueOf(unsignedShort2));
                        if (z2) {
                            android.util.Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j2);
                        }
                        if (num != null) {
                            if (unsignedShort3 == 3) {
                                unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                            } else {
                                if (unsignedShort3 == 4) {
                                    unsignedInt = seekableByteOrderedDataInputStream.readUnsignedInt();
                                } else if (unsignedShort3 == 8) {
                                    unsignedShort = seekableByteOrderedDataInputStream.readShort();
                                } else if (unsignedShort3 != 9 || unsignedShort3 == 13) {
                                    unsignedShort = seekableByteOrderedDataInputStream.readInt();
                                } else {
                                    unsignedInt = -1;
                                }
                                if (z2) {
                                    android.util.Log.d(TAG, java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(unsignedInt), exifTag.name));
                                }
                                if (unsignedInt > 0) {
                                    if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) unsignedInt))) {
                                        seekableByteOrderedDataInputStream.seek(unsignedInt);
                                        readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                                    } else if (z2) {
                                        android.util.Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                                    }
                                } else if (z2) {
                                    android.util.Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                                }
                                seekableByteOrderedDataInputStream.seek(j3);
                            }
                            unsignedInt = unsignedShort;
                            if (z2) {
                                android.util.Log.d(TAG, java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(unsignedInt), exifTag.name));
                            }
                            if (unsignedInt > 0) {
                                if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) unsignedInt))) {
                                    seekableByteOrderedDataInputStream.seek(unsignedInt);
                                    readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                                } else if (z2) {
                                    android.util.Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                                }
                            } else if (z2) {
                                android.util.Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                            }
                            seekableByteOrderedDataInputStream.seek(j3);
                        } else {
                            int iPosition = seekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                            byte[] bArr = new byte[(int) j2];
                            seekableByteOrderedDataInputStream.readFully(bArr);
                            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = new androidx.exifinterface.media.ExifInterface.ExifAttribute(unsignedShort3, i3, iPosition, bArr);
                            this.mAttributes[i].put(exifTag.name, exifAttribute);
                            if ("DNGVersion".equals(exifTag.name)) {
                                this.mMimeType = 3;
                            }
                            if (((!"Make".equals(exifTag.name) || "Model".equals(exifTag.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || ("Compression".equals(exifTag.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                this.mMimeType = 8;
                            }
                            if (seekableByteOrderedDataInputStream.position() != j3) {
                                seekableByteOrderedDataInputStream.seek(j3);
                            }
                        }
                    }
                    s2 = (short) (s2 + 1);
                    s = s;
                }
                j = jPosition;
                if (z2) {
                    android.util.Log.d(TAG, "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                j2 = 0;
                z = false;
                if (!z) {
                    seekableByteOrderedDataInputStream.seek(j);
                    s = s;
                    s2 = s2;
                } else {
                    j3 = j;
                    if (j2 > 4) {
                        i2 = seekableByteOrderedDataInputStream.readInt();
                        if (z2) {
                            android.util.Log.d(TAG, "seek to data offset: " + i2);
                        }
                        if (this.mMimeType == 7) {
                            if ("MakerNote".equals(exifTag.name)) {
                                this.mOrfMakerNoteOffset = i2;
                            } else if (i != 6) {
                            }
                        }
                        seekableByteOrderedDataInputStream.seek(i2);
                    } else {
                        unsignedShort2 = unsignedShort2;
                        i3 = i3;
                        z2 = z2;
                    }
                    num = sExifPointerTagMap.get(java.lang.Integer.valueOf(unsignedShort2));
                    if (z2) {
                        android.util.Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j2);
                    }
                    if (num != null) {
                        if (unsignedShort3 == 3) {
                            unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                        } else {
                            if (unsignedShort3 == 4) {
                                unsignedInt = seekableByteOrderedDataInputStream.readUnsignedInt();
                            } else if (unsignedShort3 == 8) {
                                unsignedShort = seekableByteOrderedDataInputStream.readShort();
                            } else {
                                if (unsignedShort3 != 9) {
                                }
                                unsignedShort = seekableByteOrderedDataInputStream.readInt();
                            }
                            if (z2) {
                                android.util.Log.d(TAG, java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(unsignedInt), exifTag.name));
                            }
                            if (unsignedInt > 0) {
                                if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) unsignedInt))) {
                                    seekableByteOrderedDataInputStream.seek(unsignedInt);
                                    readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                                } else if (z2) {
                                    android.util.Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                                }
                            } else if (z2) {
                                android.util.Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                            }
                            seekableByteOrderedDataInputStream.seek(j3);
                        }
                        unsignedInt = unsignedShort;
                        if (z2) {
                            android.util.Log.d(TAG, java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(unsignedInt), exifTag.name));
                        }
                        if (unsignedInt > 0) {
                            if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) unsignedInt))) {
                                seekableByteOrderedDataInputStream.seek(unsignedInt);
                                readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                            } else if (z2) {
                                android.util.Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                            }
                        } else if (z2) {
                            android.util.Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                        }
                        seekableByteOrderedDataInputStream.seek(j3);
                    } else {
                        int iPosition2 = seekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                        byte[] bArr2 = new byte[(int) j2];
                        seekableByteOrderedDataInputStream.readFully(bArr2);
                        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = new androidx.exifinterface.media.ExifInterface.ExifAttribute(unsignedShort3, i3, iPosition2, bArr2);
                        this.mAttributes[i].put(exifTag.name, exifAttribute2);
                        if ("DNGVersion".equals(exifTag.name)) {
                            this.mMimeType = 3;
                        }
                        if (!"Make".equals(exifTag.name)) {
                        }
                        this.mMimeType = 8;
                        if (seekableByteOrderedDataInputStream.position() != j3) {
                            seekableByteOrderedDataInputStream.seek(j3);
                        }
                    }
                }
                s2 = (short) (s2 + 1);
                s = s;
            } else if (z2) {
                android.util.Log.d(TAG, "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            }
            j = jPosition;
            j2 = 0;
            z = false;
            if (!z) {
                seekableByteOrderedDataInputStream.seek(j);
                s = s;
                s2 = s2;
            } else {
                j3 = j;
                if (j2 > 4) {
                    i2 = seekableByteOrderedDataInputStream.readInt();
                    if (z2) {
                        android.util.Log.d(TAG, "seek to data offset: " + i2);
                    }
                    if (this.mMimeType == 7) {
                        if ("MakerNote".equals(exifTag.name)) {
                            this.mOrfMakerNoteOffset = i2;
                        } else if (i != 6) {
                        }
                    }
                    seekableByteOrderedDataInputStream.seek(i2);
                } else {
                    unsignedShort2 = unsignedShort2;
                    i3 = i3;
                    z2 = z2;
                }
                num = sExifPointerTagMap.get(java.lang.Integer.valueOf(unsignedShort2));
                if (z2) {
                    android.util.Log.d(TAG, "nextIfdType: " + num + " byteCount: " + j2);
                }
                if (num != null) {
                    if (unsignedShort3 == 3) {
                        unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                    } else {
                        if (unsignedShort3 == 4) {
                            unsignedInt = seekableByteOrderedDataInputStream.readUnsignedInt();
                        } else if (unsignedShort3 == 8) {
                            unsignedShort = seekableByteOrderedDataInputStream.readShort();
                        } else {
                            if (unsignedShort3 != 9) {
                            }
                            unsignedShort = seekableByteOrderedDataInputStream.readInt();
                        }
                        if (z2) {
                            android.util.Log.d(TAG, java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(unsignedInt), exifTag.name));
                        }
                        if (unsignedInt > 0) {
                            if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) unsignedInt))) {
                                seekableByteOrderedDataInputStream.seek(unsignedInt);
                                readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                            } else if (z2) {
                                android.util.Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                            }
                        } else if (z2) {
                            android.util.Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                        }
                        seekableByteOrderedDataInputStream.seek(j3);
                    }
                    unsignedInt = unsignedShort;
                    if (z2) {
                        android.util.Log.d(TAG, java.lang.String.format("Offset: %d, tagName: %s", java.lang.Long.valueOf(unsignedInt), exifTag.name));
                    }
                    if (unsignedInt > 0) {
                        if (!this.mAttributesOffsets.contains(java.lang.Integer.valueOf((int) unsignedInt))) {
                            seekableByteOrderedDataInputStream.seek(unsignedInt);
                            readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                        } else if (z2) {
                            android.util.Log.d(TAG, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + unsignedInt + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                        }
                    } else if (z2) {
                        android.util.Log.d(TAG, "Skip jump into the IFD since its offset is invalid: " + unsignedInt);
                    }
                    seekableByteOrderedDataInputStream.seek(j3);
                } else {
                    int iPosition3 = seekableByteOrderedDataInputStream.position() + this.mOffsetToExifData;
                    byte[] bArr3 = new byte[(int) j2];
                    seekableByteOrderedDataInputStream.readFully(bArr3);
                    androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = new androidx.exifinterface.media.ExifInterface.ExifAttribute(unsignedShort3, i3, iPosition3, bArr3);
                    this.mAttributes[i].put(exifTag.name, exifAttribute3);
                    if ("DNGVersion".equals(exifTag.name)) {
                        this.mMimeType = 3;
                    }
                    if (!"Make".equals(exifTag.name)) {
                    }
                    this.mMimeType = 8;
                    if (seekableByteOrderedDataInputStream.position() != j3) {
                        seekableByteOrderedDataInputStream.seek(j3);
                    }
                }
            }
            s2 = (short) (s2 + 1);
            s = s;
        }
        int i4 = seekableByteOrderedDataInputStream.readInt();
        boolean z3 = DEBUG;
        if (z3) {
            android.util.Log.d(TAG, java.lang.String.format("nextIfdOffset: %d", java.lang.Integer.valueOf(i4)));
        }
        long j4 = i4;
        if (j4 <= 0) {
            if (z3) {
                android.util.Log.d(TAG, "Stop reading file since a wrong offset may cause an infinite loop: " + i4);
                return;
            }
            return;
        }
        if (this.mAttributesOffsets.contains(java.lang.Integer.valueOf(i4))) {
            if (z3) {
                android.util.Log.d(TAG, "Stop reading file since re-reading an IFD may cause an infinite loop: " + i4);
                return;
            }
            return;
        }
        seekableByteOrderedDataInputStream.seek(j4);
        if (this.mAttributes[4].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 4);
        } else if (this.mAttributes[5].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 5);
        }
    }

    private void retrieveJpegImageSize(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get("ImageLength");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[i].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[i].get("JPEGInterchangeFormat");
            androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[i].get("JPEGInterchangeFormatLength");
            if (exifAttribute3 == null || exifAttribute4 == null) {
                return;
            }
            int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
            seekableByteOrderedDataInputStream.seek(intValue);
            byte[] bArr = new byte[intValue2];
            seekableByteOrderedDataInputStream.read(bArr);
            getJpegAttributes(new androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream(bArr), intValue, i);
        }
    }

    private void setThumbnailData(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream) throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> map = this.mAttributes[4];
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = map.get("Compression");
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, map);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(map)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, map);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, map);
    }

    private void handleThumbnailFromJfif(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, java.util.HashMap map) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("JPEGInterchangeFormat");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (this.mMimeType == 7) {
            intValue += this.mOrfMakerNoteOffset;
        }
        if (intValue > 0 && intValue2 > 0) {
            this.mHasThumbnail = true;
            if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                byte[] bArr = new byte[intValue2];
                byteOrderedDataInputStream.skip(intValue);
                byteOrderedDataInputStream.read(bArr);
                this.mThumbnailBytes = bArr;
            }
            this.mThumbnailOffset = intValue;
            this.mThumbnailLength = intValue2;
        }
        if (DEBUG) {
            android.util.Log.d(TAG, "Setting thumbnail attributes with offset: " + intValue + ", length: " + intValue2);
        }
    }

    private void handleThumbnailFromStrips(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream byteOrderedDataInputStream, java.util.HashMap map) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("StripOffsets");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("StripByteCounts");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] jArrConvertToLongArray = androidx.exifinterface.media.ExifInterfaceUtils.convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
        long[] jArrConvertToLongArray2 = androidx.exifinterface.media.ExifInterfaceUtils.convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
        if (jArrConvertToLongArray == null || jArrConvertToLongArray.length == 0) {
            android.util.Log.w(TAG, "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrConvertToLongArray2 == null || jArrConvertToLongArray2.length == 0) {
            android.util.Log.w(TAG, "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrConvertToLongArray.length != jArrConvertToLongArray2.length) {
            android.util.Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j = 0;
        for (long j2 : jArrConvertToLongArray2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 1;
        this.mAreThumbnailStripsConsecutive = true;
        this.mHasThumbnailStrips = true;
        this.mHasThumbnail = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < jArrConvertToLongArray.length) {
            int i6 = (int) jArrConvertToLongArray[i3];
            int i7 = (int) jArrConvertToLongArray2[i3];
            if (i3 < jArrConvertToLongArray.length - i2 && i6 + i7 != jArrConvertToLongArray[i3 + 1]) {
                this.mAreThumbnailStripsConsecutive = false;
            }
            int i8 = i6 - i4;
            if (i8 < 0) {
                android.util.Log.d(TAG, "Invalid strip offset value");
                return;
            }
            long j3 = i8;
            if (byteOrderedDataInputStream.skip(j3) != j3) {
                android.util.Log.d(TAG, "Failed to skip " + i8 + " bytes.");
                return;
            }
            int i9 = i4 + i8;
            byte[] bArr2 = new byte[i7];
            if (byteOrderedDataInputStream.read(bArr2) != i7) {
                android.util.Log.d(TAG, "Failed to read " + i7 + " bytes.");
                return;
            }
            i4 = i9 + i7;
            java.lang.System.arraycopy(bArr2, 0, bArr, i5, i7);
            i5 += i7;
            i3++;
            i2 = 1;
        }
        this.mThumbnailBytes = bArr;
        if (this.mAreThumbnailStripsConsecutive) {
            this.mThumbnailOffset = (int) jArrConvertToLongArray[0];
            this.mThumbnailLength = i;
        }
    }

    private boolean isSupportedDataType(java.util.HashMap map) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute;
        int intValue;
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (java.util.Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("PhotometricInterpretation")) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && java.util.Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && java.util.Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!DEBUG) {
            return false;
        }
        android.util.Log.d(TAG, "Unsupported data type value");
        return false;
    }

    private boolean isThumbnail(java.util.HashMap map) throws java.io.IOException {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("ImageLength");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = (androidx.exifinterface.media.ExifInterface.ExifAttribute) map.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private void validateImages() throws java.lang.Throwable {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[1].get("PixelXDimension");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            this.mAttributes[0].put("ImageWidth", exifAttribute);
            this.mAttributes[0].put("ImageLength", exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>[] mapArr = this.mAttributes;
            mapArr[4] = mapArr[5];
            mapArr[5] = new java.util.HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            android.util.Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
        replaceInvalidTags(0, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(0, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(0, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(5, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(5, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(5, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(4, "Orientation", "ThumbnailOrientation");
        replaceInvalidTags(4, "ImageLength", "ThumbnailImageLength");
        replaceInvalidTags(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void updateImageSizeValues(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws java.lang.Throwable {
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort;
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort2;
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get("DefaultCropSize");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[i].get("SensorTopBorder");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[i].get("SensorLeftBorder");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[i].get("SensorBottomBorder");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute5 = this.mAttributes[i].get("SensorRightBorder");
        if (exifAttribute == null) {
            if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
                int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
                if (intValue2 <= intValue || intValue3 <= intValue4) {
                    return;
                }
                androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttributeCreateUShort4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i].put("ImageLength", exifAttributeCreateUShort3);
                this.mAttributes[i].put("ImageWidth", exifAttributeCreateUShort4);
                return;
            }
            retrieveJpegImageSize(seekableByteOrderedDataInputStream, i);
            return;
        }
        if (exifAttribute.format == 5) {
            androidx.exifinterface.media.ExifInterface.Rational[] rationalArr = (androidx.exifinterface.media.ExifInterface.Rational[]) exifAttribute.getValue(this.mExifByteOrder);
            if (rationalArr == null || rationalArr.length != 2) {
                android.util.Log.w(TAG, "Invalid crop size values. cropSize=" + java.util.Arrays.toString(rationalArr));
                return;
            }
            exifAttributeCreateUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
            exifAttributeCreateUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
        } else {
            int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
            if (iArr == null || iArr.length != 2) {
                android.util.Log.w(TAG, "Invalid crop size values. cropSize=" + java.util.Arrays.toString(iArr));
                return;
            }
            exifAttributeCreateUShort = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
            exifAttributeCreateUShort2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
        }
        this.mAttributes[i].put("ImageWidth", exifAttributeCreateUShort);
        this.mAttributes[i].put("ImageLength", exifAttributeCreateUShort2);
    }

    private int writeExifSegment(androidx.exifinterface.media.ExifInterface.ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws java.io.IOException {
        char c;
        char c2;
        androidx.exifinterface.media.ExifInterface.ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (androidx.exifinterface.media.ExifInterface.ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute("StripOffsets");
                removeAttribute("StripByteCounts");
            } else {
                removeAttribute("JPEGInterchangeFormat");
                removeAttribute("JPEGInterchangeFormatLength");
            }
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            for (java.lang.Object obj : this.mAttributes[i].entrySet().toArray()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (this.mAttributes[3].isEmpty()) {
            c = 2;
        } else {
            c = 2;
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mHasThumbnail) {
            c2 = 3;
        } else if (this.mHasThumbnailStrips) {
            this.mAttributes[4].put("StripOffsets", androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(0, this.mExifByteOrder));
            this.mAttributes[4].put("StripByteCounts", androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
            c2 = 3;
        } else {
            this.mAttributes[4].put("JPEGInterchangeFormat", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(0L, this.mExifByteOrder));
            c2 = 3;
            this.mAttributes[4].put("JPEGInterchangeFormatLength", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>> it = this.mAttributes[i2].entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int size = it.next().getValue().size();
                if (size > 4) {
                    i3 += size;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int size2 = 8;
        for (int i4 = 0; i4 < EXIF_TAGS.length; i4++) {
            if (!this.mAttributes[i4].isEmpty()) {
                iArr[i4] = size2;
                size2 += (this.mAttributes[i4].size() * 12) + 6 + iArr2[i4];
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put("StripOffsets", androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort(size2, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put("JPEGInterchangeFormat", androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(size2, this.mExifByteOrder));
            }
            this.mThumbnailOffset = size2;
            size2 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            size2 += 8;
        }
        if (DEBUG) {
            for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
                java.lang.Integer numValueOf = java.lang.Integer.valueOf(i5);
                java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(iArr[i5]);
                java.lang.Integer numValueOf3 = java.lang.Integer.valueOf(this.mAttributes[i5].size());
                java.lang.Integer numValueOf4 = java.lang.Integer.valueOf(iArr2[i5]);
                java.lang.Integer numValueOf5 = java.lang.Integer.valueOf(size2);
                java.lang.Object[] objArr = new java.lang.Object[5];
                objArr[0] = numValueOf;
                objArr[1] = numValueOf2;
                objArr[c] = numValueOf3;
                objArr[c2] = numValueOf4;
                objArr[4] = numValueOf5;
                android.util.Log.d(TAG, java.lang.String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", objArr));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[c].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[c].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(iArr[c], this.mExifByteOrder));
        }
        if (!this.mAttributes[c2].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[c2].name, androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong(iArr[c2], this.mExifByteOrder));
        }
        int i6 = this.mMimeType;
        if (i6 == 4) {
            byteOrderedDataOutputStream.writeUnsignedShort(size2);
            byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        } else if (i6 == 13) {
            byteOrderedDataOutputStream.writeInt(size2);
            byteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i6 == 14) {
            byteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
            byteOrderedDataOutputStream.writeInt(size2);
        }
        byteOrderedDataOutputStream.writeShort(this.mExifByteOrder == java.nio.ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i7 = 0; i7 < EXIF_TAGS.length; i7++) {
            if (!this.mAttributes[i7].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i7].size());
                int size3 = iArr[i7] + 2 + (this.mAttributes[i7].size() * 12) + 4;
                for (java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> entry2 : this.mAttributes[i7].entrySet()) {
                    int i8 = sExifTagMapsForWriting[i7].get(entry2.getKey()).number;
                    androidx.exifinterface.media.ExifInterface.ExifAttribute value = entry2.getValue();
                    int size4 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i8);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size4 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size3);
                        size3 += size4;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size4 < 4) {
                            while (size4 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size4++;
                            }
                        }
                    }
                }
                if (i7 == 0 && !this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                }
                java.util.Iterator<java.util.Map.Entry<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>> it2 = this.mAttributes[i7].entrySet().iterator();
                while (it2.hasNext()) {
                    androidx.exifinterface.media.ExifInterface.ExifAttribute value2 = it2.next().getValue();
                    if (value2.bytes.length > 4) {
                        byteOrderedDataOutputStream.write(value2.bytes, 0, value2.bytes.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && size2 % 2 == 1) {
            byteOrderedDataOutputStream.writeByte(0);
        }
        byteOrderedDataOutputStream.setByteOrder(java.nio.ByteOrder.BIG_ENDIAN);
        return size2;
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String str) {
        if (str.contains(",")) {
            java.lang.String[] strArrSplit = str.split(",", -1);
            android.util.Pair<java.lang.Integer, java.lang.Integer> pairGuessDataFormat = guessDataFormat(strArrSplit[0]);
            if (((java.lang.Integer) pairGuessDataFormat.first).intValue() == 2) {
                return pairGuessDataFormat;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                android.util.Pair<java.lang.Integer, java.lang.Integer> pairGuessDataFormat2 = guessDataFormat(strArrSplit[i]);
                int iIntValue = (((java.lang.Integer) pairGuessDataFormat2.first).equals(pairGuessDataFormat.first) || ((java.lang.Integer) pairGuessDataFormat2.second).equals(pairGuessDataFormat.first)) ? ((java.lang.Integer) pairGuessDataFormat.first).intValue() : -1;
                int iIntValue2 = (((java.lang.Integer) pairGuessDataFormat.second).intValue() == -1 || !(((java.lang.Integer) pairGuessDataFormat2.first).equals(pairGuessDataFormat.second) || ((java.lang.Integer) pairGuessDataFormat2.second).equals(pairGuessDataFormat.second))) ? -1 : ((java.lang.Integer) pairGuessDataFormat.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new android.util.Pair<>(2, -1);
                }
                if (iIntValue == -1) {
                    pairGuessDataFormat = new android.util.Pair<>(java.lang.Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairGuessDataFormat = new android.util.Pair<>(java.lang.Integer.valueOf(iIntValue), -1);
                }
            }
            return pairGuessDataFormat;
        }
        if (str.contains("/")) {
            java.lang.String[] strArrSplit2 = str.split("/", -1);
            if (strArrSplit2.length == 2) {
                try {
                    long j = (long) java.lang.Double.parseDouble(strArrSplit2[0]);
                    long j2 = (long) java.lang.Double.parseDouble(strArrSplit2[1]);
                    if (j >= 0 && j2 >= 0) {
                        if (j <= 2147483647L && j2 <= 2147483647L) {
                            return new android.util.Pair<>(10, 5);
                        }
                        return new android.util.Pair<>(5, -1);
                    }
                    return new android.util.Pair<>(10, -1);
                } catch (java.lang.NumberFormatException unused) {
                }
            }
            return new android.util.Pair<>(2, -1);
        }
        try {
            try {
                long j3 = java.lang.Long.parseLong(str);
                java.lang.Long lValueOf = java.lang.Long.valueOf(j3);
                lValueOf.getClass();
                if (j3 >= 0) {
                    lValueOf.getClass();
                    if (j3 <= 65535) {
                        return new android.util.Pair<>(3, 4);
                    }
                }
                lValueOf.getClass();
                if (j3 < 0) {
                    return new android.util.Pair<>(9, -1);
                }
                return new android.util.Pair<>(4, -1);
            } catch (java.lang.NumberFormatException unused2) {
                return new android.util.Pair<>(2, -1);
            }
        } catch (java.lang.NumberFormatException unused3) {
            java.lang.Double.parseDouble(str);
            return new android.util.Pair<>(12, -1);
        }
    }

    private static class SeekableByteOrderedDataInputStream extends androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] bArr) throws java.io.IOException {
            super(bArr);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        SeekableByteOrderedDataInputStream(java.io.InputStream inputStream) throws java.io.IOException {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new java.lang.IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        public void seek(long j) throws java.io.IOException {
            if (this.mPosition > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
            } else {
                j -= (long) this.mPosition;
            }
            skipFully((int) j);
        }
    }

    private static class ByteOrderedDataInputStream extends java.io.InputStream implements java.io.DataInput {
        private java.nio.ByteOrder mByteOrder;
        final java.io.DataInputStream mDataInputStream;
        int mPosition;
        private byte[] mSkipBuffer;
        private static final java.nio.ByteOrder LITTLE_ENDIAN = java.nio.ByteOrder.LITTLE_ENDIAN;
        private static final java.nio.ByteOrder BIG_ENDIAN = java.nio.ByteOrder.BIG_ENDIAN;

        ByteOrderedDataInputStream(byte[] bArr) throws java.io.IOException {
            this(new java.io.ByteArrayInputStream(bArr), java.nio.ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(java.io.InputStream inputStream) throws java.io.IOException {
            this(inputStream, java.nio.ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(java.io.InputStream inputStream, java.nio.ByteOrder byteOrder) throws java.io.IOException {
            this.mByteOrder = java.nio.ByteOrder.BIG_ENDIAN;
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            dataInputStream.mark(0);
            this.mPosition = 0;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(java.nio.ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public int position() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int available() throws java.io.IOException {
            return this.mDataInputStream.available();
        }

        @Override // java.io.InputStream
        public int read() throws java.io.IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
            int i3 = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws java.io.IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public java.lang.String readLine() throws java.io.IOException {
            android.util.Log.d(androidx.exifinterface.media.ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws java.io.IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() throws java.io.IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public java.lang.String readUTF() throws java.io.IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws java.io.IOException {
            this.mPosition += i2;
            this.mDataInputStream.readFully(bArr, i, i2);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws java.io.IOException {
            this.mPosition += bArr.length;
            this.mDataInputStream.readFully(bArr);
        }

        @Override // java.io.DataInput
        public byte readByte() throws java.io.IOException {
            this.mPosition++;
            int i = this.mDataInputStream.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new java.io.EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws java.io.IOException {
            this.mPosition += 2;
            int i = this.mDataInputStream.read();
            int i2 = this.mDataInputStream.read();
            if ((i | i2) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == BIG_ENDIAN) {
                return (short) ((i << 8) + i2);
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public int readInt() throws java.io.IOException {
            this.mPosition += 4;
            int i = this.mDataInputStream.read();
            int i2 = this.mDataInputStream.read();
            int i3 = this.mDataInputStream.read();
            int i4 = this.mDataInputStream.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public void skipFully(int i) throws java.io.IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int iSkip = (int) this.mDataInputStream.skip(i3);
                if (iSkip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[8192];
                    }
                    iSkip = this.mDataInputStream.read(this.mSkipBuffer, 0, java.lang.Math.min(8192, i3));
                    if (iSkip == -1) {
                        throw new java.io.EOFException("Reached EOF while skipping " + i + " bytes.");
                    }
                }
                i2 += iSkip;
            }
            this.mPosition += i2;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws java.io.IOException {
            this.mPosition += 2;
            int i = this.mDataInputStream.read();
            int i2 = this.mDataInputStream.read();
            if ((i | i2) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (i2 << 8) + i;
            }
            if (byteOrder == BIG_ENDIAN) {
                return (i << 8) + i2;
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        public long readUnsignedInt() throws java.io.IOException {
            return ((long) readInt()) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }

        @Override // java.io.DataInput
        public long readLong() throws java.io.IOException {
            this.mPosition += 8;
            int i = this.mDataInputStream.read();
            int i2 = this.mDataInputStream.read();
            int i3 = this.mDataInputStream.read();
            int i4 = this.mDataInputStream.read();
            int i5 = this.mDataInputStream.read();
            int i6 = this.mDataInputStream.read();
            int i7 = this.mDataInputStream.read();
            int i8 = this.mDataInputStream.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new java.io.EOFException();
            }
            java.nio.ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == LITTLE_ENDIAN) {
                return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
            }
            if (byteOrder == BIG_ENDIAN) {
                return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
            }
            throw new java.io.IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public float readFloat() throws java.io.IOException {
            return java.lang.Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() throws java.io.IOException {
            return java.lang.Double.longBitsToDouble(readLong());
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new java.lang.UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new java.lang.UnsupportedOperationException("Reset is currently unsupported");
        }
    }

    private static class ByteOrderedDataOutputStream extends java.io.FilterOutputStream {
        private java.nio.ByteOrder mByteOrder;
        final java.io.OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(java.io.OutputStream outputStream, java.nio.ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(java.nio.ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws java.io.IOException {
            this.mOutputStream.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void writeByte(int i) throws java.io.IOException {
            this.mOutputStream.write(i);
        }

        public void writeShort(short s) throws java.io.IOException {
            if (this.mByteOrder == java.nio.ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write(s & 255);
                this.mOutputStream.write((s >>> 8) & 255);
            } else if (this.mByteOrder == java.nio.ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s >>> 8) & 255);
                this.mOutputStream.write(s & 255);
            }
        }

        public void writeInt(int i) throws java.io.IOException {
            if (this.mByteOrder == java.nio.ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write(i & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 24) & 255);
                return;
            }
            if (this.mByteOrder == java.nio.ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write(i & 255);
            }
        }

        public void writeUnsignedShort(int i) throws java.io.IOException {
            writeShort((short) i);
        }

        public void writeUnsignedInt(long j) throws java.io.IOException {
            writeInt((int) j);
        }
    }

    private void swapBasedOnImageSize(int i, int i2) throws java.lang.Throwable {
        if (this.mAttributes[i].isEmpty() || this.mAttributes[i2].isEmpty()) {
            if (DEBUG) {
                android.util.Log.d(TAG, "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute = this.mAttributes[i].get("ImageLength");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute2 = this.mAttributes[i].get("ImageWidth");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute3 = this.mAttributes[i2].get("ImageLength");
        androidx.exifinterface.media.ExifInterface.ExifAttribute exifAttribute4 = this.mAttributes[i2].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            if (DEBUG) {
                android.util.Log.d(TAG, "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (exifAttribute3 == null || exifAttribute4 == null) {
            if (DEBUG) {
                android.util.Log.d(TAG, "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute>[] mapArr = this.mAttributes;
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    private void replaceInvalidTags(int i, java.lang.String str, java.lang.String str2) {
        if (this.mAttributes[i].isEmpty() || this.mAttributes[i].get(str) == null) {
            return;
        }
        java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface.ExifAttribute> map = this.mAttributes[i];
        map.put(str2, map.get(str));
        this.mAttributes[i].remove(str);
    }
}
