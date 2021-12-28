package org.yossy.framework.chunk.reader.param;

public record ReaderParameter(String line, String[] values) {

    public static class Builder {
        private String line;
        private String[] values;

        public Builder of(String line) {
            this.line = line;
            return this;
        }

        public Builder setValues() {
            this.values = this.line.split(",", -1);
            return this;
        }

        public ReaderParameter build() {
            return new ReaderParameter(this.line, this.values);
        }
    }

}
