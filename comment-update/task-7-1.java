/** Method 0 */

/** @return One of the following application running states: {@link IServer#STATE_STARTED}, {@link IServer#STATE_STARTING}, {@link IServer#STATE_STOPPED}, {@link IServer#STATE_STOPPING}, {@link IServer#STATE_UNKNOWN} */
  public int track(IProgressMonitor monitor) throws CoreException {
    long currentTime = System.currentTimeMillis();
    long totalTime = currentTime + timeout;
    CloudFoundryApplicationModule appModule =
        cloudServer.getBehaviour().updateModuleWithAllCloudInfo(appName, monitor);
    printlnToConsole(
        NLS.bind(Messages.ApplicationInstanceStartingTracker_STARTING_TRACKING, appName),
        appModule);
    int state = appModule.getState();
    while (state != IServer.STATE_STARTED
        && state != IServer.STATE_STOPPED
        && currentTime < totalTime) {
      appModule = cloudServer.getBehaviour().updateModuleWithAllCloudInfo(appName, monitor);
      if (appModule == null || appModule.getApplication() == null) {
        printlnToConsole(
            NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_NOT_EXISTS, appName),
            appModule);
        return IServer.STATE_UNKNOWN;
      }
      if (monitor != null && monitor.isCanceled()) {
        printlnToConsole(
            NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_CHECK_CANCELED, appName),
            appModule);
        return IServer.STATE_UNKNOWN;
      }
      state = appModule.getState();
      try {
        Thread.sleep(WAIT_TIME);
      } catch (InterruptedException e) {
      }
      currentTime = System.currentTimeMillis();
    }
    String runningStateMessage =
        state == IServer.STATE_STARTED
            ? NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_RUNNING, appName)
            : NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_NOT_RUNNING, appName);
    printlnToConsole(runningStateMessage, appModule);
    return state;
  }



*************************this is the dividing line*****************************



/** Method 1 */

/** @return The ruleSet */
  public RuleSet getRuleSet() {
    return this.ruleSet;
  }



*************************this is the dividing line*****************************



/** Method 2 */

/** @return red value in given position */
  public short getRed(final int i) {
    return data[get1DIndex(i)];
  }



*************************this is the dividing line*****************************



/** Method 3 */

/** @return item in given position */
  @SuppressWarnings(STR)
  public double getReal(final int i) {
    return (double) getFirstValue(i);
  }



*************************this is the dividing line*****************************



/** Method 4 */

/** @return If reached, return true; else, return false. */
  public static boolean exceedsMaxCount() {
    return mTestCount >= MAX_TEST_COUNT;
  }



*************************this is the dividing line*****************************



/** Method 5 */

/** @return -1 if the value is not valid */
  public static int getModeValue(String mode) {
    if (mode == null) return -NUM;
    mode = mode.trim().toLowerCase();
    if (mode.indexOf(STR) == -NUM) {
      if (STR.equals(mode)) {
        return MODE_INSERT;
      } else if (STR.equals(mode)) {
        return MODE_UPDATE;
      } else {
        return -NUM;
      }
    } else {
      List l = StringUtil.stringToList(mode, STR);
      String first = (String) l.get(NUM);
      String second = (String) l.get(NUM);
      if (STR.equals(first) && STR.equals(second)) {
        return MODE_INSERT_UPDATE;
      } else if (STR.equals(first) && STR.equals(second)) {
        return MODE_UPDATE_INSERT;
      } else {
        return -NUM;
      }
    }
  }



*************************this is the dividing line*****************************



/** Method 6 */

/** @return Built {@link Ct.TimestampedEntry}. */
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



*************************this is the dividing line*****************************



/** Method 7 */

/** @return The {@link android.telecomm.Connection.VideoProvider}. */
  public android.telecomm.Connection.VideoProvider getVideoProvider() {
    return mVideoProvider;
  }



*************************this is the dividing line*****************************



/** Method 8 */

/** @return project files in that directory, sorted alphabetically. */
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



*************************this is the dividing line*****************************



/** Method 9 */

/** @return the matching option, or null if no match is found and the non-null default is invalid */
  public static DdlParsingMode parse(String value, String defaultValue) {
    DdlParsingMode mode = parse(value);
    if (mode == null && defaultValue != null) {
      mode = parse(defaultValue);
    }
    return mode;
  }



*************************this is the dividing line*****************************



/** Method 10 */

/** @return true if a message was removed, false otherwise. */
  public boolean removeActiveMessage() {
    return removeMessage(currentPage);
  }



*************************this is the dividing line*****************************



/** Method 11 */

/** @return the positions offset for the header or, 3 positions, for after the body (the third position is just to indicate that it's the body, the value is meaningless) */
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



*************************this is the dividing line*****************************



/** Method 12 */

/** @return double The yaw Euler angle. */
  public double getRotY() {
    return mOrientation.getRotationY();
  }



*************************this is the dividing line*****************************



/** Method 13 */

/** @return the next power of two that is larger than the specified int value. */
  public static int nextPowerOfTwo(int value) {
    if (!isPowerOfTwo(value)) {
      value--;
      value |= value >> NUM;
      value |= value >> NUM;
      value |= value >> NUM;
      value |= value >> NUM;
      value |= value >> NUM;
      value++;
    }
    return value;
  }



*************************this is the dividing line*****************************



/** Method 14 */

/** @return the response, or an Exception if something bad happened */
  private <T> T processResponse(final ClientResponse clientResponse, final Type responseType) {
    final String response = readResponseFromClientResponse(clientResponse);
    if (clientResponse.getStatus() >= NUM) {
      throw new HandshakeAPIException(response);
    }
    try {
      return parseJson(response, responseType);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }



*************************this is the dividing line*****************************



/** Method 15 */

/** @return The generated proxy. */
  public static Blob generateProxy(InputStream stream, long length) {
    return (Blob)
        Proxy.newProxyInstance(
            getProxyClassLoader(), PROXY_INTERFACES, new BlobProxy(stream, length));
  }



*************************this is the dividing line*****************************



/** Method 16 */

/** @return The x location of the center of this circle */
  public float getX() {
    return center[NUM];
  }



*************************this is the dividing line*****************************



/** Method 17 */

/** @return The stored value or null if it doesn't exist in specified form. */
  public boolean getExtraBoolean(String key) {
    return mExtraData.optBoolean(key);
  }



*************************this is the dividing line*****************************



/** Method 18 */

/** @return the list of KDCs */
  public String getKDCList(String realm) {
    if (realm == null) {
      realm = getDefaultRealm();
    }
    String kdcs = getDefault(STR, realm);
    if (kdcs == null) {
      return null;
    }
    return kdcs;
  }



*************************this is the dividing line*****************************



/** Method 19 */

/** @return caption for that handle */
  public String getCaption(String handle) {
    return getMetadataForHandle(handle).caption_;
  }



*************************this is the dividing line*****************************



