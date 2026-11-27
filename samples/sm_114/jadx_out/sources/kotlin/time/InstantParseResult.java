package kotlin.time;

/* JADX INFO: compiled from: Instant.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bs\u0018\u00002\u00020\u0001:\u0002\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lkotlin/time/InstantParseResult;", "", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "Success", "Failure", "Lkotlin/time/InstantParseResult$Failure;", "Lkotlin/time/InstantParseResult$Success;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
interface InstantParseResult {
    kotlin.time.Instant toInstant();

    kotlin.time.Instant toInstantOrNull();

    /* JADX INFO: compiled from: Instant.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/time/InstantParseResult$Success;", "Lkotlin/time/InstantParseResult;", "epochSeconds", "", "nanosecondsOfSecond", "", "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Success implements kotlin.time.InstantParseResult {
        private final long epochSeconds;
        private final int nanosecondsOfSecond;

        public Success(long j, int i) {
            this.epochSeconds = j;
            this.nanosecondsOfSecond = i;
        }

        public final long getEpochSeconds() {
            return this.epochSeconds;
        }

        public final int getNanosecondsOfSecond() {
            return this.nanosecondsOfSecond;
        }

        @Override // kotlin.time.InstantParseResult
        public kotlin.time.Instant toInstant() {
            if (this.epochSeconds < kotlin.time.Instant.INSTANCE.getMIN$kotlin_stdlib().getEpochSeconds() || this.epochSeconds > kotlin.time.Instant.INSTANCE.getMAX$kotlin_stdlib().getEpochSeconds()) {
                throw new kotlin.time.InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + this.epochSeconds + com.taobao.weex.el.parse.Operators.BRACKET_END);
            }
            return kotlin.time.Instant.INSTANCE.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
        }

        @Override // kotlin.time.InstantParseResult
        public kotlin.time.Instant toInstantOrNull() {
            if (this.epochSeconds < kotlin.time.Instant.INSTANCE.getMIN$kotlin_stdlib().getEpochSeconds() || this.epochSeconds > kotlin.time.Instant.INSTANCE.getMAX$kotlin_stdlib().getEpochSeconds()) {
                return null;
            }
            return kotlin.time.Instant.INSTANCE.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
        }
    }

    /* JADX INFO: compiled from: Instant.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/time/InstantParseResult$Failure;", "Lkotlin/time/InstantParseResult;", "error", "", "input", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "getError", "()Ljava/lang/String;", "getInput", "()Ljava/lang/CharSequence;", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Failure implements kotlin.time.InstantParseResult {
        private final java.lang.String error;
        private final java.lang.CharSequence input;

        @Override // kotlin.time.InstantParseResult
        public kotlin.time.Instant toInstantOrNull() {
            return null;
        }

        public Failure(java.lang.String error, java.lang.CharSequence input) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(error, "error");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
            this.error = error;
            this.input = input;
        }

        public final java.lang.String getError() {
            return this.error;
        }

        public final java.lang.CharSequence getInput() {
            return this.input;
        }

        @Override // kotlin.time.InstantParseResult
        public kotlin.time.Instant toInstant() {
            throw new kotlin.time.InstantFormatException(this.error + " when parsing an Instant from \"" + kotlin.time.InstantKt.truncateForErrorMessage(this.input, 64) + '\"');
        }
    }
}
