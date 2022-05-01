Method 0 

  protected String getExample(Property property) {
    if (property.getExample() != null) {
      return property.getExample().toString();
    } else if (property instanceof DateTimeProperty) {
      return "2000-01-23T04:56:07.000Z";
    } else if (property instanceof DateProperty) {
      return "2000-01-23";
    } else if (property instanceof BooleanProperty) {
      return "true";
    } else if (property instanceof LongProperty) {
      return "123456789";
    } else if (property
        instanceof DoubleProperty) { // derived from DecimalProperty so make sure this is first
      return "3.149";
    } else if (property instanceof DecimalProperty) {
      return "1.3579";
    } else if (property instanceof PasswordProperty) {
      return "********";
    } else if (property instanceof UUIDProperty) {
      return "046b6c7f-0b8a-43b9-b35d-6489e6daee91";
      // do these last in case the specific types above are derived from these classes
    } else if (property instanceof StringProperty) {
      return "aeiou";
    } else if (property instanceof BaseIntegerProperty) {
      return "123";
    } else if (property instanceof AbstractNumericProperty) {
      return "1.23";
    }
    LOGGER.warn("default example value not implemented for " + property);
    return "";
  }



=======================================================



Method 1 

  public static String normalizeDateString(String s, Date docdate) {
    // TODO [pengqi]: still need to handle relative dates ("å»å¹´") and temporal references
    // ("å½æ¶")
    // TODO [pengqi]: need to handle irregular years ("81å¹´")
    // TODO [pengqi]: need to handle basic localization ("å¨ä¸æäºæ¥å°[å
«æ¥]é´")
    Pattern p = Pattern.compile(BASIC_YYYYMMDD_PATTERN);
    Matcher m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();
      String year = m.group(1);
      for (int i = 0; i < year.length(); i++) {
        String t = "" + year.charAt(i);
        if (CHINESE_LITERAL_DECIMAL_PATTERN.matcher(t).matches()) {
          if (wordsToValues.containsKey(t)) res.append((int) wordsToValues.getCount(t));
          else
            // something unexpected happened
            return null;
        } else res.append(t);
      }

      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2)));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(3)));

      return res.toString();
    }

    p = Pattern.compile(BASIC_MMDD_PATTERN);
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 2) {
      StringBuilder res = new StringBuilder();
      String year = new SimpleDateFormat("yyyy").format(docdate);

      res.append(year);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1)));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2)));

      return res.toString();
    }

    p = Pattern.compile(BASIC_DD_PATTERN);
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 1) {
      StringBuilder res = new StringBuilder();
      String year = new SimpleDateFormat("yyyy").format(docdate);
      String month = new SimpleDateFormat("MM").format(docdate);

      res.append(year);
      res.append("-");
      res.append(month);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1)));

      return res.toString();
    }

    p = Pattern.compile(ENGLISH_MMDDYYYY_PATTERN);
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();

      String year = new SimpleDateFormat("yyyy").format(docdate);

      if (m.group(3) == null) res.append(year);
      else res.append(m.group(3));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1)));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2)));

      return res.toString();
    }

    return s;
  }



=======================================================



Method 2 

  @SuppressWarnings(STR)
  public double getReal(final int i) {
    return (double) getFirstValue(i);
  }



=======================================================



Method 3 

  public boolean isFlagSet(int flag) {
    return (flags & flag) != 0;
  }



=======================================================



Method 4 

  public static final TokenStream of(TokenStream... streams) {
    return new TokenStreamAggregator(streams);
  }



=======================================================



Method 5 

  public T bothV() {
    return this.add(new BothVerticesPipe());
  }



=======================================================



Method 6 

  private File[] getProjectFiles(File directory) {
    File[] files =
        directory.listFiles(
            new FileFilter() {

              public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(STR));
              }
            });
    switch (explorerTableSortColumn) {
      case NUM:
      case NUM:
      case NUM:
      default:
    }
    selectedFile = -NUM;
    if (getProject() != null)
      for (int n = NUM; n < files.length; n++)
        if (getProject().getFile().equals(files[n])) selectedFile = n;
    return files;
  }



=======================================================



Method 7 

  public List<Set<?>> getProjectInfo(AbstractProject context) {

    Comparator customComparator =
        new Comparator<AbstractProject>() {
          public int compare(AbstractProject abstractProject1, AbstractProject abstractProject2) {
            return abstractProject1.getFullName().compareTo(abstractProject2.getFullName());
          }
        };

    Set<AbstractProject> dynamicProject = new TreeSet<AbstractProject>(customComparator);
    Set<AbstractProject> staticProject = new TreeSet<AbstractProject>(customComparator);
    Set<AbstractProject> triggeredProject = new TreeSet<AbstractProject>(customComparator);
    Set<String> unresolvedProject = new TreeSet<String>();

    iterateBuilds(
        context, projects, dynamicProject, staticProject, triggeredProject, unresolvedProject);

    // We don't want to show a project twice
    triggeredProject.removeAll(dynamicProject);
    triggeredProject.removeAll(staticProject);

    return Arrays.asList(staticProject, dynamicProject, triggeredProject, unresolvedProject);
  }



=======================================================



Method 8 

  File getBaseDir(File base, File file) {
    if (base == null) {
      return file.getParentFile().getAbsoluteFile();
    } else {
      Iterator bases = getParents(base).iterator();
      Iterator fileParents = getParents(file.getAbsoluteFile()).iterator();
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
  }



=======================================================



Method 9 

  public static int[] getViewToHeaderBodyPosition(
      JTextArea view, String header, int start, int end) {
    validateView(view);
    validateHeader(header);
    validateStartEnd(start, end, view.getDocument().getLength());

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



=======================================================



Method 10 

  public static boolean exceedsMaxCount() {
    return mTestCount >= MAX_TEST_COUNT;
  }



=======================================================



Method 11 

  private ComponentAdapter prepRES_lifecycleManagerHonorsInstantiationSequence(
      MutablePicoContainer picoContainer) {
    picoContainer.component(RecordingLifecycle.One.class);
    PoolingComponentAdapter poolingComponentAdapter =
        new PoolingComponentAdapter(
            new ConstructorInjectionComponentAdapter(
                RecordingLifecycle.Recorder.class, RecordingLifecycle.Two.class));
    return picoContainer.adapter(poolingComponentAdapter).lastCA();
  }



=======================================================



Method 12 

  private int updateRedundancy() {
    int numBucketHosts = getNumInitializedBuckets();
    if (!isClosed()) {
      redundancyTracker.updateStatistics(numBucketHosts);
    }
    return numBucketHosts;
  }



=======================================================



Method 13 

  public android.telecomm.Connection.VideoProvider getVideoProvider() {
    return mVideoProvider;
  }



=======================================================



Method 14 

  public boolean equals(Object readableInterval) {
    if (this == readableInterval) {
      return true;
    }
    if (readableInterval instanceof ReadableInterval == false) {
      return false;
    }
    ReadableInterval other = (ReadableInterval) readableInterval;
    return (getStartMillis() == other.getStartMillis() && getEndMillis() == other.getEndMillis());
  }



=======================================================



Method 15 

  protected String determineSegmentColumnName(Properties params, Dialect dialect) {
    final ObjectNameNormalizer normalizer =
        (ObjectNameNormalizer) params.get(IDENTIFIER_NORMALIZER);
    final String name =
        ConfigurationHelper.getString(SEGMENT_COLUMN_PARAM, params, DEF_SEGMENT_COLUMN);
    return normalizer.toDatabaseIdentifierText(name);
  }



=======================================================



Method 16 

  public double getRotY() {
    return mOrientation.getRotationY();
  }



=======================================================



Method 17 

  public String createText(MilStd2525TacticalGraphic graphic) {
    String functionId = graphic.getFunctionId();
    if (CircularFireSupportArea.FUNCTION_ID_TARGET.equals(functionId)) return graphic.getText();
    else return createDateRangeText(graphic, functionId);
  }



=======================================================



Method 18 

  public static DdlParsingMode parse(String value, String defaultValue) {
    DdlParsingMode mode = parse(value);
    if (mode == null && defaultValue != null) {
      mode = parse(defaultValue);
    }
    return mode;
  }



=======================================================



Method 19 

  public static Ct.TimestampedEntry parseTimestampedEntry(InputStream in) {
    Ct.TimestampedEntry.Builder timestampedEntry = Ct.TimestampedEntry.newBuilder();
    long timestamp = readNumber(in, CTConstants.TIMESTAMP_LENGTH);
    timestampedEntry.setTimestamp(timestamp);
    int entryType = (int) readNumber(in, CTConstants.LOG_ENTRY_TYPE_LENGTH);
    timestampedEntry.setEntryType(Ct.LogEntryType.valueOf(entryType));
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
    signedEntryBuilder.build();
    timestampedEntry.setSignedEntry(signedEntryBuilder);
    return timestampedEntry.build();
  }



=======================================================



