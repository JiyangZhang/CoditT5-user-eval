/** Method 0 */

/** updated comment */
  public int track(IProgressMonitor monitor) throws CoreException, OperationCanceledException {
    long currentTime = System.currentTimeMillis();
    long totalTime = currentTime + timeout;
    CloudFoundryServerBehaviour behaviour = cloudServer.getBehaviour();
    String appName = appModule.getDeployedApplicationName();
    printlnToConsole(
        NLS.bind(Messages.ApplicationInstanceStartingTracker_STARTING_TRACKING, appName),
        appModule);
    int state = IServer.STATE_UNKNOWN;
    while (state != IServer.STATE_STARTED
        && state != IServer.STATE_STOPPED
        && currentTime < totalTime) {
      if (monitor != null && monitor.isCanceled()) {
        String error =
            NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_CHECK_CANCELED, appName);
        printlnToConsole(error, appModule);
        throw new OperationCanceledException(error);
      }
      CloudApplication cloudApp = behaviour.getCloudApplication(appName, monitor);
      ApplicationStats applicationStats = behaviour.getApplicationStats(appName, monitor);
      if (cloudApp == null) {
        String error =
            NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_NOT_EXISTS, appName);
        printlnToConsole(error, appModule);
        throw CloudErrorUtil.toCoreException(error);
      } else {
        state = CloudFoundryApplicationModule.getCloudState(cloudApp, applicationStats);
        try {
          Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
        }
        currentTime = System.currentTimeMillis();
      }
    }
    String runningStateMessage =
        state == IServer.STATE_STARTED
            ? NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_RUNNING, appName)
            : NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_NOT_RUNNING, appName);
    printlnToConsole(runningStateMessage, appModule);
    return state;
  }



==========================this is the dividing line=============================



/** Method 1 */

/** updated comment */
  public Package getRuleSet() {
    return this.pkg;
  }



==========================this is the dividing line=============================



/** Method 2 */

/** updated comment */
  public short getRed() {
    return data[getFirst1DIndex()];
  }



==========================this is the dividing line=============================



/** Method 3 */

/** updated comment */
  @SuppressWarnings(STR)
  public double getReal() {
    return (double) getFirstValue();
  }



==========================this is the dividing line=============================



/** Method 4 */

/** updated comment */
  public static boolean exceedsMaxCount() {
    final long maxTestCount = HostConfig.getMaxTestCount();
    return (maxTestCount > NUM) && (mTestCount >= maxTestCount);
  }



==========================this is the dividing line=============================



/** Method 5 */

/** updated comment */
  public static ImportMode getModeValue(String mode) {
    if (mode == null) return null;
    mode = mode.trim().toLowerCase();
    if (mode.indexOf(STR) == -NUM) {
      if (STR.equals(mode)) {
        return ImportMode.insert;
      } else if (STR.equals(mode)) {
        return ImportMode.update;
      } else {
        return null;
      }
    } else {
      List l = StringUtil.stringToList(mode, STR);
      String first = (String) l.get(NUM);
      String second = (String) l.get(NUM);
      if (STR.equals(first) && STR.equals(second)) {
        return ImportMode.insertUpdate;
      } else if (STR.equals(first) && STR.equals(second)) {
        return ImportMode.updateInsert;
      } else {
        return null;
      }
    }
  }



==========================this is the dividing line=============================



/** Method 6 */

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



/** Method 7 */

/** updated comment */
  public android.telecom.Connection.VideoProvider getVideoProvider() {
    return mVideoProvider;
  }



==========================this is the dividing line=============================



/** Method 8 */

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



/** Method 9 */

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



/** Method 10 */

/** updated comment */
  public int removeActiveMessage() {
    return removeMessage(currentPage);
  }



==========================this is the dividing line=============================



/** Method 11 */

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



/** Method 12 */

/** updated comment */
  public double getRotY() {
    return Math.toDegrees(mOrientation.getRotationY());
  }



==========================this is the dividing line=============================



/** Method 13 */

/** updated comment */
  public static int nextPowerOfTwo(final int value) {
    return NUM << (NUM - Integer.numberOfLeadingZeros(value - NUM));
  }



==========================this is the dividing line=============================



/** Method 14 */

/** updated comment */
  private <T> T processResponse(final ClientResponse clientResponse, final Type responseType) {
    final String response = readResponseFromClientResponse(clientResponse);
    if (clientResponse.getStatus() == NUM) {
      return null;
    } else if (clientResponse.getStatus() >= NUM) {
      throw new HandshakeAPIException(response);
    }
    try {
      return parseJson(response, responseType);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }



==========================this is the dividing line=============================



/** Method 15 */

/** updated comment */
  public static Blob generateProxy(InputStream stream, long length) {
    return new BlobProxy(stream, length);
  }



==========================this is the dividing line=============================



/** Method 16 */

/** updated comment */
  public float getX() {
    if (left == null) {
      calculateLeft();
    }
    return left.floatValue();
  }



==========================this is the dividing line=============================



/** Method 17 */

/** updated comment */
  public boolean getExtraBoolean(String key) throws JSONException {
    return mExtraData.getBoolean(key);
  }



==========================this is the dividing line=============================



/** Method 18 */

/** updated comment */
  public String getKDCList(String realm) throws KrbException {
    if (realm == null) {
      realm = getDefaultRealm();
    }
    Exception cause = null;
    String kdcs = getDefault(STR, realm);
    if (kdcs == null) {
      kdcs =
          java.security.AccessController.doPrivileged(
              new java.security.PrivilegedAction<String>() {

                @Override
                public String run() {
                  String osname = System.getProperty(STR);
                  if (osname.startsWith(STR)) {
                    String logonServer = System.getenv(STR);
                    if (logonServer != null && logonServer.startsWith(STR)) {
                      logonServer = logonServer.substring(NUM);
                    }
                    return logonServer;
                  }
                  return null;
                }
              });
    }
    if (kdcs == null) {
      KrbException ke = new KrbException(STR);
      if (cause != null) {
        ke.initCause(cause);
      }
      throw ke;
    }
    return kdcs;
  }



==========================this is the dividing line=============================



/** Method 19 */

/** updated comment */
  public String getCaption(String handle) {
    TerminalMetadata data = getMetadataForHandle(handle);
    if (data == null) {
      return null;
    }
    return data.caption_;
  }



==========================this is the dividing line=============================



