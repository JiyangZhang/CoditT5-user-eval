/** Method 0 */

/** updated comment */
  protected String getExample(Schema schema) {
    if (schema.getExample() != null) {
      return schema.getExample().toString();
    } else if (ModelUtils.isDateTimeSchema(schema)) {
      return "2000-01-23T04:56:07.000Z";
    } else if (ModelUtils.isDateSchema(schema)) {
      return "2000-01-23";
    } else if (ModelUtils.isBooleanSchema(schema)) {
      return "true";
    } else if (ModelUtils.isNumberSchema(schema)) {
      if (ModelUtils.isFloatSchema(schema)) { // float
        return "1.3579";
      } else { // double
        return "3.149";
      }
    } else if (ModelUtils.isPasswordSchema(schema)) {
      return "********";
    } else if (ModelUtils.isUUIDSchema(schema)) {
      return "046b6c7f-0b8a-43b9-b35d-6489e6daee91";
      // do these last in case the specific types above are derived from these classes
    } else if (ModelUtils.isStringSchema(schema)) {
      return "aeiou";
    } else if (ModelUtils.isIntegerSchema(schema)) {
      if (ModelUtils.isLongSchema(schema)) { // long
        return "123456789";
      } else { // integer
        return "123";
      }
    } else {
      LOGGER.debug(
          "default example value not implemented for {}. Default to UNDEFINED_EXAMPLE_VALUE",
          schema);
      return "UNDEFINED_EXAMPLE_VALUE";
    }
  }



==========================this is the dividing line=============================



/** Method 1 */

/** updated comment */
  public static String normalizeDateString(String s, Date ctxdate) {
    // TODO [pengqi]: need to handle basic localization ("å¨ä¸æäºæ¥å°[å
«æ¥]é´")
    // TODO [pengqi]: need to handle literal numeral dates (usually used in events, e.g. "ä¸ä¸äº"
    // for 03-15)
    // TODO [pengqi]: might need to add a pattern for centuries ("ä¸ä¸çºª90å¹´ä»£")?
    String ctxyear = new SimpleDateFormat("yyyy").format(ctxdate);
    String ctxmonth = new SimpleDateFormat("MM").format(ctxdate);
    String ctxday = new SimpleDateFormat("dd").format(ctxdate);

    Pattern p = Pattern.compile("^" + BASIC_YYYYMMDD_PATTERN + "$");
    Matcher m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();

      res.append(normalizeYear(m.group(1), ctxyear));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2), ctxmonth));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(3), ctxday));

      return res.toString();
    }

    p = Pattern.compile("^" + BASIC_MMDD_PATTERN + "$");
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 2) {
      StringBuilder res = new StringBuilder();

      res.append(ctxyear);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1), ctxmonth));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2), ctxday));

      return res.toString();
    }

    p = Pattern.compile("^" + BASIC_DD_PATTERN + "$");
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 1) {
      StringBuilder res = new StringBuilder();

      res.append(ctxyear);
      res.append("-");
      res.append(ctxmonth);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1), ctxday));

      return res.toString();
    }

    p = Pattern.compile("^" + ENGLISH_MMDDYYYY_PATTERN + "$");
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();

      if (m.group(3) == null) res.append(ctxyear);
      else res.append(normalizeYear(m.group(3), ctxyear));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1), ctxmonth));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2), ctxday));

      return res.toString();
    }

    return s;
  }



==========================this is the dividing line=============================



/** Method 2 */

/** updated comment */
  @SuppressWarnings(STR)
  public double getReal() {
    return (double) getFirstValue();
  }



==========================this is the dividing line=============================



/** Method 3 */

/** updated comment */
  public boolean isFlagSet(int flagsToCheck) {
    return (flags & flagsToCheck) != 0;
  }



==========================this is the dividing line=============================



/** Method 4 */

/** updated comment */
  public static final TwitterTokenStream of(TwitterTokenStream... streams) {
    return new TokenStreamAggregator(streams);
  }



==========================this is the dividing line=============================



/** Method 5 */

/** updated comment */
  public GremlinPipeline<S, Vertex> bothV() {
    return this.add(new BothVerticesPipe());
  }



==========================this is the dividing line=============================



/** Method 6 */

/** updated comment */
  private File[] getProjectFiles(File directory) {
    return directory.listFiles(
        new FileFilter() {

          public boolean accept(File file) {
            return (file.isFile() && file.getName().endsWith(STR));
          }
        });
  }



==========================this is the dividing line=============================



/** Method 7 */

/** updated comment */
  public SubProjectData getProjectInfo(AbstractProject context) {

    SubProjectData subProjectData = new SubProjectData();

    iterateBuilds(context, projects, subProjectData);

    // We don't want to show a project twice
    subProjectData.getTriggered().removeAll(subProjectData.getDynamic());
    subProjectData.getTriggered().removeAll(subProjectData.getFixed());

    return subProjectData;
  }



==========================this is the dividing line=============================



/** Method 8 */

/** updated comment */
  File getBaseDir(final File file1, final File file2) {
    if (file1 == null || file2 == null) {
      return null;
    }
    final Iterator bases = getParents(file1).iterator();
    final Iterator fileParents = getParents(file2.getAbsoluteFile()).iterator();
    File result = null;
    while (bases.hasNext() && fileParents.hasNext()) {
      File next = (File) bases.next();
      if (next.equals(fileParents.next())) {
        result = next;
      } else {
        break;
      }
    }
    return result;
  }



==========================this is the dividing line=============================



/** Method 9 */

/** updated comment */
  public static int[] getViewToHeaderBodyPosition(
      JTextArea view, String header, int start, int end) {
    validateView(view);
    validateHeader(header);
    validateStartEnd(start, end);

    if (!isValidStartEndForLength(start, end, view.getDocument().getLength())) {
      return INVALID_POSITION;
    }

    int excessChars = 0;
    int pos = 0;
    while ((pos = header.indexOf("\r\n", pos)) != -1) {
      pos += 2;
      ++excessChars;
    }

    if (start + excessChars < header.length()) {
      int[] position = getViewToHeaderPositionImpl(view, start, end);
      if (position[1] > header.length()) {
        position[1] = header.length();
      }
      return position;
    }

    int finalStartPos = start + excessChars - header.length();
    int finalEndPos = end + excessChars - header.length();
    return new int[] {finalStartPos, finalEndPos, 0};
  }



==========================this is the dividing line=============================



/** Method 10 */

/** updated comment */
  public static boolean exceedsMaxCount() {
    final long maxTestCount = HostConfig.getMaxTestCount();
    return (maxTestCount > NUM) && (mTestCount >= maxTestCount);
  }



==========================this is the dividing line=============================



/** Method 11 */

/** updated comment */
  private ComponentAdapter prepRES_lifecycleManagerHonorsInstantiationSequence(
      MutablePicoContainer picoContainer) {
    picoContainer.addComponent(RecordingLifecycle.One.class);
    PoolingComponentAdapter poolingComponentAdapter =
        new PoolingComponentAdapter(
            new ConstructorInjectionComponentAdapter(
                RecordingLifecycle.Recorder.class, RecordingLifecycle.Two.class));
    return picoContainer.addAdapter(poolingComponentAdapter).lastCA();
  }



==========================this is the dividing line=============================



/** Method 12 */

/** updated comment */
  private int updateRedundancy() {
    int desiredRedundancy = this.pRegion.getRedundantCopies();
    int numBucketHosts = getNumInitializedBuckets();
    if (isClosed()) {
      return numBucketHosts;
    }
    int actualRedundancy = numBucketHosts - 1;
    this.redundancy = actualRedundancy;
    if (this.redundancySatisfied && numBucketHosts > 0 && actualRedundancy < desiredRedundancy) {
      incLowRedundancyBucketCount(1);
      this.redundancySatisfied = false;
    } else if (!this.redundancySatisfied
        && numBucketHosts > 0
        && actualRedundancy >= desiredRedundancy) {
      incLowRedundancyBucketCount(-1);
      this.redundancySatisfied = true;
      this.redundancyEverSatisfied = true;
    }
    return numBucketHosts;
  }



==========================this is the dividing line=============================



/** Method 13 */

/** updated comment */
  public android.telecom.Connection.VideoProvider getVideoProvider() {
    return mVideoProvider;
  }



==========================this is the dividing line=============================



/** Method 14 */

/** updated comment */
  public boolean equals(Object readableInterval) {
    if (this == readableInterval) {
      return true;
    }
    if (readableInterval instanceof ReadableInterval == false) {
      return false;
    }
    ReadableInterval other = (ReadableInterval) readableInterval;
    return (getStartMillis() == other.getStartMillis()
        && getEndMillis() == other.getEndMillis()
        && getChronology() == other.getChronology());
  }



==========================this is the dividing line=============================



/** Method 15 */

/** updated comment */
  protected String determineSegmentColumnName(Properties params, JdbcEnvironment jdbcEnvironment) {
    final String name =
        ConfigurationHelper.getString(SEGMENT_COLUMN_PARAM, params, DEF_SEGMENT_COLUMN);
    return jdbcEnvironment
        .getIdentifierHelper()
        .toIdentifier(name)
        .render(jdbcEnvironment.getDialect());
  }



==========================this is the dividing line=============================



/** Method 16 */

/** updated comment */
  public double getRotY() {
    return Math.toDegrees(mOrientation.getRotationY());
  }



==========================this is the dividing line=============================



/** Method 17 */

/** updated comment */
  public String[] createText(MilStd2525TacticalGraphic graphic) {
    String[] result;

    String functionId = graphic.getFunctionId();
    if (CircularFireSupportArea.FUNCTION_ID_TARGET.equals(functionId)) {
      result = new String[] {graphic.getText()};
    } else {
      boolean useSeparateTimeLabel = this.isShowSeparateTimeLabel(functionId);
      String mainText = this.createMainText(graphic, functionId, !useSeparateTimeLabel);

      if (useSeparateTimeLabel) {
        String timeText = this.createTimeRangeText(graphic);
        result = new String[] {mainText, timeText};
      } else {
        result = new String[] {mainText};
      }
    }
    return result;
  }



==========================this is the dividing line=============================



/** Method 18 */

/** updated comment */
  public static EventProcessingFailureHandlingMode parse(String value) {
    if (value == null) {
      return null;
    }

    value = value.trim();

    for (EventProcessingFailureHandlingMode option : EventProcessingFailureHandlingMode.values()) {
      if (option.getValue().equalsIgnoreCase(value)) {
        return option;
      }
    }

    return null;
  }



==========================this is the dividing line=============================



/** Method 19 */

/** updated comment */
  public static TimestampedEntry parseTimestampedEntry(InputStream in) {
    TimestampedEntry timestampedEntry = new TimestampedEntry();
    timestampedEntry.timestamp = readNumber(in, CTConstants.TIMESTAMP_LENGTH);
    int entryType = (int) readNumber(in, CTConstants.LOG_ENTRY_TYPE_LENGTH);
    timestampedEntry.entryType = Ct.LogEntryType.valueOf(entryType);
    Ct.SignedEntry.Builder signedEntryBuilder = Ct.SignedEntry.newBuilder();
    if (entryType == Ct.LogEntryType.X509_ENTRY_VALUE) {
      int length = (int) readNumber(in, NUM);
      ByteString x509 = ByteString.copyFrom(readFixedLength(in, length));
      signedEntryBuilder.setX509(x509);
    } else if (entryType == Ct.LogEntryType.PRECERT_ENTRY_VALUE) {
      Ct.PreCert.Builder preCertBuilder = Ct.PreCert.newBuilder();
      byte[] arr = readFixedLength(in, NUM);
      preCertBuilder.setIssuerKeyHash(ByteString.copyFrom(arr));
      arr = readFixedLength(in, NUM);
      int length = (int) readNumber(in, NUM);
      preCertBuilder.setTbsCertificate(ByteString.copyFrom(readFixedLength(in, length)));
      preCertBuilder.build();
      signedEntryBuilder.setPrecert(preCertBuilder);
    } else {
      throw new SerializationException(String.format(STR, entryType));
    }
    timestampedEntry.signedEntry = signedEntryBuilder.build();
    return timestampedEntry;
  }



==========================this is the dividing line=============================



