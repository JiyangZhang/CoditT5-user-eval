/** Example 0 */

/** ['style nit: no braces around single line blocks', 'style nit: no braces around single line blocks'] */
private void createIndex() {
		lastFoundElementPosition = 0;

		filteredPlan.clear();
		for (PlanElement element : plan.getList()) {
			if (!element.isComment()) {
				filteredPlan.add(element);
			}
		}
	}



private void createIndex() {
		lastFoundElementPosition = 0;

		filteredPlan.clear();
		for (PlanElement element : plan.getList()) {
			if (!element.isComment()) {
				filteredPlan.add(element);
			}
		}
	}



*************************this is the dividing line*****************************



/** Example 1 */

/** ['is there a difference between parallelStream() and entryStream().parallel() ?', 'is there a difference between parallelStream() and entryStream().parallel() ?'] */
public Collection<Map.Entry<K, V>> scanAndFilterByEntry(
            Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return mainMap.entryStream().parallel()
                .filter(entryPredicate)
                .collect(Collectors.toCollection(ArrayList::new));
    }



public Collection<Map.Entry<K, V>> scanAndFilterByEntry(
            Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return mainMap.entryStream().parallel()
                .filter(entryPredicate)
                .collect(Collectors.toCollection(ArrayList::new));
    }



*************************this is the dividing line*****************************



/** Example 2 */

/** ['can be `private`? or at least package protected access?'] */
protected boolean isValidChar(final char c) {
        return isValidChar(regExp, c);
    }



*************************this is the dividing line*****************************



/** Example 3 */

/** ['Toni, could we please choose better variable names here? `equals` and `equals1` do not say much for newcomer to the codebase.  Or we could avoid storing partial results by: ```java if(!Objects.equals(editorPlaceRequest, event.getPlace())) { return false; }  if (!Objects.equals(getEditorIdentifier(), event.getPlace().getIdentifier())) { return false; } return true; ```  Please let me know what do you think.', 'Toni, could we please choose better variable names here? `equals` and `equals1` do not say much for newcomer to the codebase.  Or we could avoid storing partial results by: ```java if(!Objects.equals(editorPlaceRequest, event.getPlace())) { return false; }  if (!Objects.equals(getEditorIdentifier(), event.getPlace().getIdentifier())) { return false; } return true; ```  Please let me know what do you think.'] */
public boolean verifyEventIdentifier(AbstractPlaceEvent event) {
        boolean equals = Objects.equals(getEditorIdentifier(),
                                        event.getPlace().getIdentifier());
        boolean equals1 = Objects.equals(editorPlaceRequest,
                                         event.getPlace());
        return (equals &&
                equals1);
    }



public boolean verifyEventIdentifier(AbstractPlaceEvent event) {
        boolean equals = Objects.equals(getEditorIdentifier(),
                                        event.getPlace().getIdentifier());
        boolean equals1 = Objects.equals(editorPlaceRequest,
                                         event.getPlace());
        return (equals &&
                equals1);
    }



*************************this is the dividing line*****************************



/** Example 4 */

/** ["It's an obvious code duplication. We can save this new request with a modified URI into `this.request`, and use it in all methods. This is how it works in other classes, take a look"] */
public void star() throws IOException {
        this.entry.uri()
            .path(RtGist.PATH_ELEMENT_STAR).back().method("PUT")
            .fetch().as(RestResponse.class)
            .assertStatus(HttpURLConnection.HTTP_NO_CONTENT);
    }



*************************this is the dividing line*****************************



/** Example 5 */

/** ["What is the need to make `issueArticles` nullable? It would be easier to understand this view class if we required it.  If that's totally impractical, we should consider having a separate view class to capture the difference.", "What is the need to make `issueArticles` nullable? It would be easier to understand this view class if we required it.  If that's totally impractical, we should consider having a separate view class to capture the difference."] */
public IssueOutputView(Issue issue) {
    this(issue, null, null);
  }



public IssueOutputView(Issue issue) {
    this(issue, null, null);
  }



*************************this is the dividing line*****************************



/** Example 6 */

/** ['not 100% sure, but this breaks binary compatibility, right?', 'not 100% sure, but this breaks binary compatibility, right?'] */
public ProcessEngineConfiguration setDefaultNumberOfRetries(int defaultNumberOfRetries) {
    this.defaultNumberOfRetries = defaultNumberOfRetries;
    return this;
  }



public ProcessEngineConfiguration setDefaultNumberOfRetries(int defaultNumberOfRetries) {
    this.defaultNumberOfRetries = defaultNumberOfRetries;
    return this;
  }



*************************this is the dividing line*****************************



/** Example 7 */

/** ['The Exception is never thrown.'] */
public void testSequenceFlowSupplier() throws Exception {
        final CaseManagementSetChildNodeGraphCommand command = new CaseManagementSetChildNodeGraphCommand(parent,
                                                                                                          candidate,
                                                                                                          index,
                                                                                                          originalParent,
                                                                                                          originalIndex);

        final Supplier<ViewConnector<SequenceFlow>> supplier = command.sequenceFlowSupplier();
        final ViewConnector<SequenceFlow> viewConnector = supplier.get();

        assertNotNull(viewConnector);
        assertNotNull(viewConnector.getSourceConnection());
        assertNotNull(viewConnector.getTargetConnection());
        assertNotNull(viewConnector.getBounds());
        assertNotNull(viewConnector.getDefinition());
    }



*************************this is the dividing line*****************************



/** Example 8 */

/** ["instead of an early assignment which might be overridden in line 2355, it can be set as the 'else' part of the if statement below (line 2356).", "instead of an early assignment which might be overridden in line 2355, it can be set as the 'else' part of the if statement below (line 2356)."] */
public long getSessionSeqId() {
        if (sessionSeqId == null) {
            sessionSeqId = -1L;
            String sessionId = getContext().getEngineContext().getSessionId();
            // The session may not exists for quartz jobs
            if (getSessionDataContainer().isSessionExists(sessionId)) {
                sessionSeqId = getSessionDataContainer().getEngineSessionSeqId(sessionId);
            }
        }
        return sessionSeqId;
    }



public long getSessionSeqId() {
        if (sessionSeqId == null) {
            sessionSeqId = -1L;
            String sessionId = getContext().getEngineContext().getSessionId();
            // The session may not exists for quartz jobs
            if (getSessionDataContainer().isSessionExists(sessionId)) {
                sessionSeqId = getSessionDataContainer().getEngineSessionSeqId(sessionId);
            }
        }
        return sessionSeqId;
    }



*************************this is the dividing line*****************************



/** Example 9 */

/** ['Allocate write ID is a DB/table related event and should be ignored if not lookup on this DB/table.', 'Allocate write ID is a DB/table related event and should be ignored if not lookup on this DB/table.'] */
private boolean isTxnRelatedEvent(final NotificationEvent event) {
    return ((event.getEventType().equals(MessageFactory.OPEN_TXN_EVENT)) ||
            (event.getEventType().equals(MessageFactory.COMMIT_TXN_EVENT)) ||
            (event.getEventType().equals(MessageFactory.ABORT_TXN_EVENT)) ||
            (event.getEventType().equals(MessageFactory.ALLOC_WRITE_ID_EVENT))
          );
  }



private boolean isTxnRelatedEvent(final NotificationEvent event) {
    return ((event.getEventType().equals(MessageFactory.OPEN_TXN_EVENT)) ||
            (event.getEventType().equals(MessageFactory.COMMIT_TXN_EVENT)) ||
            (event.getEventType().equals(MessageFactory.ABORT_TXN_EVENT)) ||
            (event.getEventType().equals(MessageFactory.ALLOC_WRITE_ID_EVENT))
          );
  }



*************************this is the dividing line*****************************



/** Example 10 */

/** ["Can't we have this static flag on FS instead? Then we wouldn't need to make FileStoreAttributeCache public.", "Can't we have this static flag on FS instead? Then we wouldn't need to make FileStoreAttributeCache public."] */
public static void setBackground(boolean async) {
			background = async;
		}



public static void setBackground(boolean async) {
			background = async;
		}



*************************this is the dividing line*****************************



/** Example 11 */

/** ['For a small maximuSize, like 1, it may be more reasonable to check for:  map.size() > maximumSize', 'For a small maximuSize, like 1, it may be more reasonable to check for:  map.size() > maximumSize'] */
public V put(@NonNull K key, @NonNull V value) {
		map.put(key, new Entry<>(key, value, ++time));
		if (map.size() >= maximumSize) {
			purge();
		}
		return value;
	}



public V put(@NonNull K key, @NonNull V value) {
		map.put(key, new Entry<>(key, value, ++time));
		if (map.size() >= maximumSize) {
			purge();
		}
		return value;
	}



*************************this is the dividing line*****************************



/** Example 12 */

/** ["Shouldn't do this line - it's handled by the ...Optionally... bit in the Encr class. https://github.com/pentaho/pentaho-kettle/blob/master/core/src/org/pentaho/di/core/encryption/KettleTwoWayPasswordEncoder.java#L86-L91", "Shouldn't do this line - it's handled by the ...Optionally... bit in the Encr class. https://github.com/pentaho/pentaho-kettle/blob/master/core/src/org/pentaho/di/core/encryption/KettleTwoWayPasswordEncoder.java#L86-L91"] */
private static void setIfNotNullOrEmpty( MongoProperties.Builder builder, MongoProp prop, String value ) {
    if ( value != null && value.trim().length() > 0 ) {
      boolean isPassword = MongoProp.PASSWORD.equals( prop );
      boolean isEncrypted = value.startsWith( Encr.PASSWORD_ENCRYPTED_PREFIX );
      if ( isPassword && isEncrypted ) {
        value = Encr.decryptPasswordOptionallyEncrypted( value );
      }
      builder.set( prop, value );
    }
  }



private static void setIfNotNullOrEmpty( MongoProperties.Builder builder, MongoProp prop, String value ) {
    if ( value != null && value.trim().length() > 0 ) {
      boolean isPassword = MongoProp.PASSWORD.equals( prop );
      boolean isEncrypted = value.startsWith( Encr.PASSWORD_ENCRYPTED_PREFIX );
      if ( isPassword && isEncrypted ) {
        value = Encr.decryptPasswordOptionallyEncrypted( value );
      }
      builder.set( prop, value );
    }
  }



*************************this is the dividing line*****************************



/** Example 13 */

/** ['One use/test case is, a non-serializable pojo (user type) that is encoded as a UTF-8 byte[ ] with some string representation of it.', 'One use/test case is, a non-serializable pojo (user type) that is encoded as a UTF-8 byte[ ] with some string representation of it.'] */
public Mutation toMutation(K key) {
      V valueFromStorage = (V) valueDataConversion.fromStorage(value);
      return new Mutations.ReadWriteWithValue<>(valueFromStorage, f);
   }



public Mutation toMutation(K key) {
      V valueFromStorage = (V) valueDataConversion.fromStorage(value);
      return new Mutations.ReadWriteWithValue<>(valueFromStorage, f);
   }



*************************this is the dividing line*****************************



/** Example 14 */

/** ['IMHO it does not need to be public', 'IMHO it does not need to be public'] */
public Entry(Map.Entry<String,String> e) {
		    this(e.getKey(), e.getValue());
        }



public Entry(Map.Entry<String,String> e) {
		    this(e.getKey(), e.getValue());
        }



*************************this is the dividing line*****************************



/** Example 15 */

/** ['parts[1].isEmpty', 'parts[1].isEmpty'] */
private String parsePath() throws URISyntaxException {
    String[] parts = uri.split("\\?")[0].split(":", 2);

    if (parts.length < 2 || parts[1].length() < 1) throw new URISyntaxException(uri, "invalid path");
    else                                           return parts[1];
  }



private String parsePath() throws URISyntaxException {
    String[] parts = uri.split("\\?")[0].split(":", 2);

    if (parts.length < 2 || parts[1].length() < 1) throw new URISyntaxException(uri, "invalid path");
    else                                           return parts[1];
  }



*************************this is the dividing line*****************************



/** Example 16 */

/** ['this will affect the sorting also on the webadmin - but on webadmin we support sortable columns.  Please move this logic to UserPortalTemplateListModel.', 'this will affect the sorting also on the webadmin - but on webadmin we support sortable columns.  Please move this logic to UserPortalTemplateListModel.'] */
public void setItems(Collection value) {
        genVersionToBaseTemplate(value);
        final List<VmTemplate> sortedValues = sortTemplates(value);
        super.setItems(sortedValues);
    }



public void setItems(Collection value) {
        genVersionToBaseTemplate(value);
        final List<VmTemplate> sortedValues = sortTemplates(value);
        super.setItems(sortedValues);
    }



*************************this is the dividing line*****************************



/** Example 17 */

/** ['why you need this line? table.setRowData(new ArrayList<ListModel>());', 'why you need this line? table.setRowData(new ArrayList<ListModel>());'] */
public void edit(VolumeBrickModel object) {
        table.setRowData(new ArrayList<ListModel>());
        table.edit(object.getBricks());
        Driver.driver.edit(object);
    }



public void edit(VolumeBrickModel object) {
        table.setRowData(new ArrayList<ListModel>());
        table.edit(object.getBricks());
        Driver.driver.edit(object);
    }



*************************this is the dividing line*****************************



/** Example 18 */

/** ['`return quickFilters`'] */
public List<QuickFilter> getQuickFilters() {
        return this.quickFilters;
    }



*************************this is the dividing line*****************************



/** Example 19 */

/** ['why not directly assertEquals(LOW, fCondition.min()); ?', 'why not directly assertEquals(LOW, fCondition.min()); ?', 'why not directly assertEquals(LOW, fCondition.min()); ?'] */
public void testBounds() {
        int low = fCondition.min();
        assertEquals(LOW, low);
        int high = fCondition.max();
        assertEquals(HIGH, high);
    }



public void testBounds() {
        int low = fCondition.min();
        assertEquals(LOW, low);
        int high = fCondition.max();
        assertEquals(HIGH, high);
    }



public void testBounds() {
        int low = fCondition.min();
        assertEquals(LOW, low);
        int high = fCondition.max();
        assertEquals(HIGH, high);
    }



*************************this is the dividing line*****************************



